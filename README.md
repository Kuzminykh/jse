### Описание приложения task-manager
***
Учебный проект в рамках курса Java.

*`Ссылка на Github:`* https://github.com/Kuzminykh/jse

#### Требования к Hardware
1. CPU i5 / i7
2. RAM 16GB (8gb )
3. LAN / WI-FI
4. SSD 40GB (НDD)

#### Требование к Software: 
1. Java 11.0. 
2. Apache Maven 3.6.3
3. Java Open JDK 11

#### Стек технологий:
1. Java Open JDK 11
2. Apache Maven 3.6.3
3. Intellij Idea 2020.1.2
4. Git 2.27.0

#### Разработчик: 
 Кузьминых Н.Н. (ООО "НЛМК-Иниформационные технологии" г.Екатеринбург)
 
#### e-mail: 
 kuzminyh_nn@nlmk.com

#### Сборка приложения: 
- `mvn clean` - Удаление всех созданных в процессе сборки артефактов
- `mvn package` - Создание пакета
- `mvn install` - Копирование .jar в удаленный репозиторий

#### Команда для запуска приложения: 
``` 
java -jar target/task-manager-1.0.7.jar 
```

*Дополнительные параметры запуска (териминальные команды):*
```
 * about - Информация о разработчике
 * version - Версия программы
 * help - Отображение списка терминальных команд
 * exit - Выход из приложения

 * project-list - Отображение списка проектов
 * project-create - Создать новый проект по имени
 * project-clear - Удалить все проекты
 * project-view-index - Просмотр проекта по индексу
 * project-view-id - Просмотр проекта по идентификатору
 * project-remove-by-index - Удаление проекта по индексу
 * project-remove-by-id - Удаление проекта по идентификатору
 * project-remove-by-name - Удаление проекта по имени
 * project-update-by-index - Изменение проекта по индексу
 * project-update-by-id - Изменение проекта по идентификатору
 

 * task-list - Отображение списка задач
 * task-create - Создать новую задачу по имени
 * task-clear - Удалить все задачи
 * task-view-index - Просмотр задачи по индексу
 * task-view-id - Просмотр задачи по идентификатору
 * task-remove-by-index - Удаление задачи по индексу
 * task-remove-by-id - Удаление задачи по идентификатору
 * task-remove-by-name - Удаление задачи по имени
 * task-update-by-index - Изменение задачи по индексу
 * task-update-by-id - Изменение задачи по идентификатору

 * task-list-by-project-id - Отображение списка задач по идентификатору проекта
 * task-add-to-project-by-ids - Добавить задачу в проект по идентификатору
 * task-remove-form-project-by-ids - Удалить задачу из проекта по идентификатору
```
 #
- *`Настроено окружение для протокола SSH для отправки изменений в Git`*
- *`Настроена сборка на CI/CD в Gitlab`*
- *`Интегрирован аккаунт Gitlab с Github`*
- *`Настроен Autopush из Gitlab в Github`* 

