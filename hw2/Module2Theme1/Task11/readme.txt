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

Добавил файл Temp.txt, добавил его в гит для отслеживания командой:
$ git add .

Зафиксировал локальное изменение командой:
$ git commit -m "commit for hw1 Task 11 in new branch added file Temp.txt"
[newBranch d31f82c] commit for hw1 Task 11 in new branch added file Temp.txt
 2 files changed, 1 insertion(+)
 create mode 100644 hw2/Module2Theme1/Task11/Temp.txt

При смене ветки на ветку master командой git checkout в проводнике Windows наблюдаем 
что добавленные в ветви newBranch файлы отсутствуют. При повторной смене на ветку newBranch они появляются.

Произвел слияние ветвей командой:
$ git merge newBranch
Updating b44fc2e..d31f82c
Fast-forward
 hw2/Module2Theme1/Task11/Temp.txt   | 0
 hw2/Module2Theme1/Task11/readme.txt | 1 +
 2 files changed, 1 insertion(+)
 create mode 100644 hw2/Module2Theme1/Task11/Temp.txt

