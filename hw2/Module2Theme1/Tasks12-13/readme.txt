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
выполните откат изменений и проверьте статус выполнения операции