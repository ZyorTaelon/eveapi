all:
		mvn -Plocal install jar:test-jar javadoc:jar javadoc:test-jar source:jar source:test-jar assembly:single
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
		mvn -Plocal install; mvn -Plocal release:prepare; svn up -r head; mvn -Plocal install; mvn -Plocal release:prepare -Dresume; mvn release:clean;
