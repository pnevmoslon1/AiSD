## Лабораторная работа 3
### 1 шаг

Скачать и развернуть контейнер с операционной системой согласно варианту. ID контейнера задаётся согласно порядковому номеру в списке группы, но с припиской «1» в начале. Т.е. первый студент в группе создаёт контейнер с ID 101, а 28ой студент в списке создаёт контейнер 128 Создать в контейнере пользователя ОС, логин – имя студента на латинице. В дальнейшем данный контейнер будет называться «первый контейнер»

В Веб-консоли Proxmox: 
- local (в левой панели) -> Templates -> Скачиваем контейнер по варианту -> Create CT -> ID по варианту -> Пароль -> Выбираем свой Template -> Дальше всё по дефолту

Запускаем контейнер, в контейнере: 
- `adduser *name*` -> Пароль

### 2 шаг

Настроить внутреннюю сеть для контейнера и доступ из внутренней сети во внешнюю в веб-интерфейсе Proxmox Virtual Environment. Внутренняя сеть контейнеров должна иметь вид 192.168.X.Y, где X – номер студента в группе, а Y – номер контейнера. Т.е. 28ой студент в группе настраивает IP адрес контейнера 192.168.28.128

В Веб-консоли Proxmox: 
- pve-\*ФИО\* -> System -> Network -> Create -> Linux Bridge -> Name: `vmbr1` (пох, но у меня будет так) -> Create -> Apply Configuration -> CIDR: `192.168.X.100/24`, Gateway `пустой`
- 1X (CT1X) (Контейнер) (в левой панели) -> Network -> Brigde: `vmbr1` -> IP address: `192.168.X.Y/24` -> Gateway: `192.168.X.100`

В консоли Proxmox:
- `nano /etc/network/interfaces` -> под vmbr1 пишем (заменить X):
```bash
		post-up echo 1 > /proc/sys/net/ipv4/ip_forward
		post-up   iptables -t nat -A POSTROUTING -s '192.168.X.0/24' -o vmbr0 -j MASQUERADE
		post-down iptables -t nat -D POSTROUTING -s '192.168.X.0/24' -o vmbr0 -j MASQUERADE
```
- `ifup vmbr0 && ifup vmbr1 && systemctl restart networking`
### 3 шаг

Запустить контейнер. Произвести обновление системы. Проверку обновления нужно будет произвести повторно при преподавателе. Обновление проводится только при помощи команд оболочки

В Веб-консоли Proxmox: 
- 1X (CT1X) (Контейнер) (в левой панели) -> Console -> Зависит от варианта:
	- Fedora, CentOS Stream, Rocky Linux, AlmaLinux: `dnf update`
	- Debian, Ubuntu: `apt update && apt upgrade`
	- Arch Linux: `pacman -Syu`
### 4 шаг

Установить и настроить в виртуальной машине систему обратного проксирования по TCP портам nginx stream. Входящий порт – номер контейнера + «22», т.е. 28ой студент в группе настраивает входящий в nginx stream 12822

В VirtualBox: 
- Пробросьте порты: 
	порт хоста и гостя: `CTID + "22"`

В консоли Proxmox:
- `nano /etc/nginx/nginx.conf` -> дописать:
```nginx
stream {
        # SSH CT106
        server {
                listen 10622;
                proxy_pass 192.168.6.106:22;
        }
}
```

### 5 шаг

Подключиться из хостовой машины к контейнеру внутри виртуальной машины по ssh. При необходимости сконфигурировать Virtualbox для доступа к ssh контейнера из хостовой машины.

В терминале Windows:
- `ssh root@localhost -p <CTID + "22">`
### 6 шаг

Продемонстрировать преподавателю одновременный доступ к:
1. Командной оболочке виртуальной машины Proxmox Virtual Environment под пользователем root
2. Командной оболочке контейнера под созданным пользователем
3. Главной странице веб-сервера nginx, установленного в лабораторной работе №2

Ну ёпта тут сами давайте да?