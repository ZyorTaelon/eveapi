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
		mvn -Pproduction install; mvn -Pproduction release:prepare; svn up -r head; mvn -Pproduction install jar:test-jar javadoc:jar javadoc:test-jar source:jar source:test-jar assembly:single; mvn -Pproduction release:prepare -Dresume; mvn release:clean;
