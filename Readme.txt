//Please enter the following data into the specified tables
INSERT INTO users(username,password,enabled)
VALUES ('root','12', true);
INSERT INTO users(username,password,enabled)
VALUES ('ravi','12', true);

INSERT INTO user_roles (user_role_id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (user_role_id, name)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_and_role (username, user_role_id)
VALUES ('root', 1);
INSERT INTO user_and_role (username, user_role_id)
VALUES ('root', 2);


Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target
$ git status
fatal: not a git repository (or any of the parent directories): .git

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target
$ git init
Initialized empty Git repository in C:/Users/Ravi/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target/.git/

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        classes/
        test-classes/

nothing added to commit but untracked files present (use "git add" to track)

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git add .
warning: LF will be replaced by CRLF in classes/META-INF/maven/com.adj.amgmt/asset-management3.0/pom.xml.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in classes/application.properties.
The file will have its original line endings in your working directory

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   classes/META-INF/MANIFEST.MF
        new file:   classes/META-INF/maven/com.adj.amgmt/asset-management3.0/pom.properties
        new file:   classes/META-INF/maven/com.adj.amgmt/asset-management3.0/pom.xml
        new file:   classes/application.properties
        new file:   classes/com/adj/amgmt/Application.class
        new file:   classes/com/adj/amgmt/config/ApplicationConfig.class
        new file:   classes/com/adj/amgmt/controller/AccessoryController.class
        new file:   classes/com/adj/amgmt/controller/AccessoryIssuesController.class
        new file:   classes/com/adj/amgmt/controller/AccessoryTypeController.class
        new file:   classes/com/adj/amgmt/controller/AppController.class
        new file:   classes/com/adj/amgmt/controller/AssetAssignmentController.class
        new file:   classes/com/adj/amgmt/controller/AssetController.class
        new file:   classes/com/adj/amgmt/controller/AssetTypeController.class
        new file:   classes/com/adj/amgmt/controller/EmployeeController.class
        new file:   classes/com/adj/amgmt/dto/AccessoryDTO.class
        new file:   classes/com/adj/amgmt/dto/AccessoryIssueDTO.class
        new file:   classes/com/adj/amgmt/dto/AccessoryTypesDTO.class
        new file:   classes/com/adj/amgmt/dto/AssetAssignmentDTO.class
        new file:   classes/com/adj/amgmt/dto/AssetDTO.class
        new file:   classes/com/adj/amgmt/dto/AssetTypeDTO.class
        new file:   classes/com/adj/amgmt/dto/EmployeeDTO.class
        new file:   classes/com/adj/amgmt/dto/User.class
        new file:   classes/com/adj/amgmt/entity/Accessory.class
        new file:   classes/com/adj/amgmt/entity/AccessoryIssue.class
        new file:   classes/com/adj/amgmt/entity/AccessoryTypes.class
        new file:   classes/com/adj/amgmt/entity/Account.class
        new file:   classes/com/adj/amgmt/entity/Article.class
        new file:   classes/com/adj/amgmt/entity/Asset.class
        new file:   classes/com/adj/amgmt/entity/AssetAssignment.class
        new file:   classes/com/adj/amgmt/entity/AssetTypes.class
        new file:   classes/com/adj/amgmt/entity/Employee.class
        new file:   classes/com/adj/amgmt/entity/User.class
        new file:   classes/com/adj/amgmt/entity/UserRole.class
        new file:   classes/com/adj/amgmt/repository/AccessoryIssueRepository.class
        new file:   classes/com/adj/amgmt/repository/AccessoryRepository.class
        new file:   classes/com/adj/amgmt/repository/AccessoryTypeRepository.class
        new file:   classes/com/adj/amgmt/repository/AssetAssignmentRepository.class
        new file:   classes/com/adj/amgmt/repository/AssetRepository.class
        new file:   classes/com/adj/amgmt/repository/AssetTypeRepository.class
        new file:   classes/com/adj/amgmt/repository/EmployeeRepository.class
        new file:   classes/com/adj/amgmt/repository/UserRepository.class
        new file:   classes/com/adj/amgmt/service/AccessoryIssueService.class
        new file:   classes/com/adj/amgmt/service/AccessoryIssueServiceImpl$1.class
        new file:   classes/com/adj/amgmt/service/AccessoryIssueServiceImpl.class
        new file:   classes/com/adj/amgmt/service/AccessoryService.class
        new file:   classes/com/adj/amgmt/service/AccessoryServiceImpl.class
        new file:   classes/com/adj/amgmt/service/AccessoryTypeService.class
        new file:   classes/com/adj/amgmt/service/AccessoryTypesServiceImpl$1.class
        new file:   classes/com/adj/amgmt/service/AccessoryTypesServiceImpl.class
        new file:   classes/com/adj/amgmt/service/AssetAssignmentService.class
        new file:   classes/com/adj/amgmt/service/AssetAssignmentServiceImpl$1.class
        new file:   classes/com/adj/amgmt/service/AssetAssignmentServiceImpl.class
        new file:   classes/com/adj/amgmt/service/AssetService.class
        new file:   classes/com/adj/amgmt/service/AssetTypeService.class
        new file:   classes/com/adj/amgmt/service/AssetTypesServiceImpl$1.class
        new file:   classes/com/adj/amgmt/service/AssetTypesServiceImpl.class
        new file:   classes/com/adj/amgmt/service/AssetsServiceImpl.class
        new file:   classes/com/adj/amgmt/service/EmployeeService.class
        new file:   classes/com/adj/amgmt/service/EmployeeServiceImpl$1.class
        new file:   classes/com/adj/amgmt/service/EmployeeServiceImpl.class
        new file:   classes/static/css/home.css
        new file:   classes/static/img/74.png
        new file:   classes/static/img/background.png
        new file:   classes/static/img/login.jpg
        new file:   classes/static/img/m (2).jpg
        new file:   classes/static/img/pngegg.png
        new file:   classes/static/img/que.png
        new file:   test-classes/com/adj/amgmt/ApplicationTests.class


Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git commit -m "Initial Commit"
[master (root-commit) fcf9065] Initial Commit
 68 files changed, 270 insertions(+)
 create mode 100644 classes/META-INF/MANIFEST.MF
 create mode 100644 classes/META-INF/maven/com.adj.amgmt/asset-management3.0/pom.properties
 create mode 100644 classes/META-INF/maven/com.adj.amgmt/asset-management3.0/pom.xml
 create mode 100644 classes/application.properties
 create mode 100644 classes/com/adj/amgmt/Application.class
 create mode 100644 classes/com/adj/amgmt/config/ApplicationConfig.class
 create mode 100644 classes/com/adj/amgmt/controller/AccessoryController.class
 create mode 100644 classes/com/adj/amgmt/controller/AccessoryIssuesController.class
 create mode 100644 classes/com/adj/amgmt/controller/AccessoryTypeController.class
 create mode 100644 classes/com/adj/amgmt/controller/AppController.class
 create mode 100644 classes/com/adj/amgmt/controller/AssetAssignmentController.class
 create mode 100644 classes/com/adj/amgmt/controller/AssetController.class
 create mode 100644 classes/com/adj/amgmt/controller/AssetTypeController.class
 create mode 100644 classes/com/adj/amgmt/controller/EmployeeController.class
 create mode 100644 classes/com/adj/amgmt/dto/AccessoryDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/AccessoryIssueDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/AccessoryTypesDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/AssetAssignmentDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/AssetDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/AssetTypeDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/EmployeeDTO.class
 create mode 100644 classes/com/adj/amgmt/dto/User.class
 create mode 100644 classes/com/adj/amgmt/entity/Accessory.class
 create mode 100644 classes/com/adj/amgmt/entity/AccessoryIssue.class
 create mode 100644 classes/com/adj/amgmt/entity/AccessoryTypes.class
 create mode 100644 classes/com/adj/amgmt/entity/Account.class
 create mode 100644 classes/com/adj/amgmt/entity/Article.class
 create mode 100644 classes/com/adj/amgmt/entity/Asset.class
 create mode 100644 classes/com/adj/amgmt/entity/AssetAssignment.class
 create mode 100644 classes/com/adj/amgmt/entity/AssetTypes.class
 create mode 100644 classes/com/adj/amgmt/entity/Employee.class
 create mode 100644 classes/com/adj/amgmt/entity/User.class
 create mode 100644 classes/com/adj/amgmt/entity/UserRole.class
 create mode 100644 classes/com/adj/amgmt/repository/AccessoryIssueRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/AccessoryRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/AccessoryTypeRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/AssetAssignmentRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/AssetRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/AssetTypeRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/EmployeeRepository.class
 create mode 100644 classes/com/adj/amgmt/repository/UserRepository.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryIssueService.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryIssueServiceImpl$1.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryIssueServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryService.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryTypeService.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryTypesServiceImpl$1.class
 create mode 100644 classes/com/adj/amgmt/service/AccessoryTypesServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/AssetAssignmentService.class
 create mode 100644 classes/com/adj/amgmt/service/AssetAssignmentServiceImpl$1.class
 create mode 100644 classes/com/adj/amgmt/service/AssetAssignmentServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/AssetService.class
 create mode 100644 classes/com/adj/amgmt/service/AssetTypeService.class
 create mode 100644 classes/com/adj/amgmt/service/AssetTypesServiceImpl$1.class
 create mode 100644 classes/com/adj/amgmt/service/AssetTypesServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/AssetsServiceImpl.class
 create mode 100644 classes/com/adj/amgmt/service/EmployeeService.class
 create mode 100644 classes/com/adj/amgmt/service/EmployeeServiceImpl$1.class
 create mode 100644 classes/com/adj/amgmt/service/EmployeeServiceImpl.class
 create mode 100644 classes/static/css/home.css
 create mode 100644 classes/static/img/74.png
 create mode 100644 classes/static/img/background.png
 create mode 100644 classes/static/img/login.jpg
 create mode 100644 classes/static/img/m (2).jpg
 create mode 100644 classes/static/img/pngegg.png
 create mode 100644 classes/static/img/que.png
 create mode 100644 test-classes/com/adj/amgmt/ApplicationTests.class

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git status
On branch master
nothing to commit, working tree clean

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git remote add origin https://github.com/RaviPraswal/AssetManagement.git

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$ git push origin master
Enumerating objects: 91, done.
Counting objects: 100% (91/91), done.
Delta compression using up to 12 threads
Compressing objects: 100% (83/83), done.
Writing objects: 100% (91/91), 1.56 MiB | 1.69 MiB/s, done.
Total 91 (delta 13), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (13/13), done.
remote:
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/RaviPraswal/AssetManagement/pull/new/master
remote:
To https://github.com/RaviPraswal/AssetManagement.git
 * [new branch]      master -> master

Ravi@LAPTOP-E3KGAKJP MINGW64 ~/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/asset-management3.0/target (master)
$
