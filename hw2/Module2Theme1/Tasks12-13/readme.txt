Задание 12
Выполните задание 11 для другой локальной папки, сделайте изменения кода в
двух папках, произведите операции обновления и фиксирования изменений локальных
папок и разрешите возникший конфликт.

Создал папку gitTemp и скопировал туда проект командой:
$ git clone https://github.com/Rual333/jd2_hw.git

Создал файл readme.txt с текстом 12 задания. Занес изменения  в удаленный репозиторий командой:
$ git push origin master

В директории homework создал файл readme.txt с текстом 13 задания. Сделал коммит. Прочитал изменения командой
$ git pull origin master
CONFLICT (directory/file): There is a directory with name hw2/Module2Theme1/Tasks12-13/readme.txt in HEAD. 
Adding hw2/Module2Theme1/Tasks12-13/readme.txt as hw2/Module2Theme1/
Tasks12-13/readme.txt~b7af195b487b6d9d4d2ec71947b38b0feb4a0a68
Automatic merge failed; fix conflicts and then commit the result.

Вручную разрешил конфликт.


Задание 13
Внесите изменения в ваш веб проект, например, измените текст на jsp. Затем
выполните откат изменений и проверьте статус выполнения операции.

Изменил .txt текст на .jsp. 
Зафиксировал изменения. 
Командой git revert откатил изменения.
$ git revert -m 1 0519504f3e2bc8ec8834b795cc16cf788880b836
Adding hw2/Module2Theme1/Tasks12-13/readme.txt/readme.txt
[master 8f02d65] Revert "hw2 Task 12 fixed conflict"
 1 file changed, 3 insertions(+)
 create mode 100644 hw2/Module2Theme1/Tasks12-13/readme.txt/readme.txt

Проверил лог:
commit 8f02d6547932dc3dcbe4100f9f1eebd9188bcd1d (HEAD -> master)
Author: Ivan <Chromer.00@gmail.com>
Date:   Tue Dec 22 21:51:57 2020 +0300

    Revert "hw2 Task 12 fixed conflict"

    This reverts commit 0519504f3e2bc8ec8834b795cc16cf788880b836, reversing
    changes made to 39f5aabad23a6653f6868dbe770194dfcca25a27.
    hw2 Task 13

 


