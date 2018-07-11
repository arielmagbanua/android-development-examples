# android-mobile-app-dev-examples

## Git Guidelines and Commands

* Repository initialization and configuration.
	```bash
	# initialize the repo
	git init
	
	# add the remote origin of the repo
	git remote add origin https://github.com/user/repo.git
	
	# verify remote origin
	origin  https://github.com/user/repo.git (fetch)
	origin  https://github.com/user/repo.git (push)
	```

* Cloning a repository.
	```bash
	git clone https://github.com/user/repo.git
	# example
	git clone https://github.com/arielmagbanua/android-mobile-app-dev-examples.git
	```

* Set-up email and user name.
	```bash
	git config user.email "juan_dela_cruz@example.com"
	git config user.name "Juan Dela Cruz"
	```

* Adding untracked files or delete files.
	```bash
	# add a file to track
	git add file_name

	# add all files
	git add -A
	```

* Commiting and pushing changes and added files.
	```bash
	# commit
	git commit -am "My commit message"

	# push to a branch
	git push origin master
	```

* Pulling and merging changes from a branch.
	```bash
	# pull any updates from a branch
	git pull origin master

	# all changes will be merged and will notify for merge conflicts. 
	# if there are conflicts then resolve them manually.
	# commit and push the changes to a branch
	git push origin master
	```