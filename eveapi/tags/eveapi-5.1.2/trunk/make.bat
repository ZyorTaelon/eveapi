@echo off
if "%1"=="all" goto :all
if "%1"=="fast" goto :fast
if "%1"=="test" goto :test
if "%1"=="clean" goto :clean
if "%1"=="config" goto :config
if "%1"=="dependencies" goto :dependencies
if "%1"=="site" goto :site
if "%1"=="release" goto :release
echo no goal specified doing fast
:fast
    call mvn -Dmaven.test.skip=true install
    if %errorlevel% neq 0 goto :done
		goto :done
:all
		call mvn clean install
    if %errorlevel% neq 0 goto :done
		goto :done
:test
		call mvn test
		goto :done
:clean
		call mvn clean
		goto :done
:config
		call mvn -DdownloadSources=true eclipse:eclipse
		goto :done
:dependencies
		call mvn project-info-reports:dependencies
		cmd /c "target\site\dependencies.html"
		goto :done
:site
		call mvn site
		goto :done
:release
	call mvn -Pproduction install
	call mvn -Pproduction release:prepare
	call svn up -r head
	call mvn -Pproduction jar:test-jar javadoc:jar javadoc:test-jar source:jar source:test-jar deploy assembly:single
	call mvn -Pproduction release:prepare -Dresume
	call mvn release:clean
	goto :done
:done