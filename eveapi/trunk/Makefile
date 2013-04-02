all:
		mvn -Plocal install
fast:
		mvn -Plocal -Dmaven.test.skip=true install
test:
		mvn -Plocal test
clean:
		mvn -Plocal clean
config:
		mvn -Plocal -DdownloadSources=true eclipse:eclipse
site:
		mvn -Plocal site-deploy
release:
		mvn release:perform
