Remove-Item -Path ./doc/ -Recurse
javadoc -author -version -tag pre:cm:"Precondition" -tag post:cm:"Postcondition" -d ./doc/ -classpath ./lib/* -sourcepath ./src/ kgurushankar.shapes