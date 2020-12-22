Задание 11
Скопируйте веб-проект в хранилище, созданное ранее. Затем скачайте (checkout)
изменения в отдельный каталог. Попробуйте изменить что-либо в вашем проекте
ипосмотрите на статус папок в проводнике Windows.


Копирование веб-проекта в локальный репозиторий совершаетя командой:
git clone https://github.com/Rual333/jd2_hw.git

Изменения заносятся в удаленный репозиторий командой git push.

добавил папку Module2Theme1. проверил статус папок командой git status:
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        hw2/Module2Theme1/

nothing added to commit but untracked files present (use "git add" to track)

Создал новую ветвь и перешел на нее:
$ git checkout -b newBranch
Switched to a new branch 'newBranch'

