datemine
========

A great task manager


## Installation

I don't know how to make it properly. Java has so many dependencies ... So if you have a better idea, feel free to tell me what I should write next.

#### Step 1 : SQL

We're using **mySQL** for its simplicity but you can easily change, but the only thing is that I can't help you anymore if you choose the powerfull way.

**If you choose MySQL**, just follow this simple steps :

- Get the _datemine.sql_ file in the _Other Ressources_ folder. [on GitHub](https://github.com/thomasleduc/datemine/blob/master/src/main/resources/datetime.sql "datetime.sql")
- Launch a mysql server.
- Execute it in your favorite mysql manager (_Mysql Workbench_ for example).

**Else** they are 5 tables to create :

- User (id, login, passwd, email, creationdate) : The user table
- Project (id, name, description, owner, ???) : The project table
- Task(id, name, status, progress, parent, project, ???) : The task table
- Sharing (id, user, project, right): The _relationship_ table that configure the right of users on project

#### Step 2 : NetBeans

Once again, if you don't want to use other IDE ... ~~up to you~~.

- Create a web applications.
File > New Project > Maven > Web Application. **Call it datemine** and the main package **com.epita.mti**.


- Go in the project folder

``` sh
cd ~/NetBeansProjects/datemine/
```

- Get the remote sources (<sub><sup>guess what ? you need to have git install</sup></sub>), in the project folder :

``` git
git init
git remote add origin https://github.com/thomasleduc/datemine.git
git pull
git commit -am 'merge with an awesome project, My name is *yourname*'
```
#### Step 3 : Glassfish

-Build and clean the project : ![Netbeans clean & build icon](http://2.bp.blogspot.com/_9hmP3Ho0t14/S3CbTCYXxqI/AAAAAAAAAY4/AOvjXs3cgec/s400/Picture+10.png "Netbeans clean & build icon")

### Test

After installing NB 6.0, get NB 6.0 'RESTful Web Services' plugin from the NB 6.0 IDE menu "Tools->Plugins->Available Plugins. After installing the plugin(s), IDE restarts.
