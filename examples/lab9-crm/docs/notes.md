test 1:

rename pom got this error:
PS C:\Users\somed\java-bootcamp\module-08-lab8> mvn compile
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.108 s
[INFO] Finished at: 2026-09-09T10:12:20-04:00
[INFO] ------------------------------------------------------------------------
[ERROR] The goal you specified requires a project to execute but there is no POM in this directory (C:\Users\somed\java-bootcamp\module-08-lab8). Please verify you invoked Maven from the correct directory. -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MissingProjectException

realized there was no pom xml and gave an error
test 2:

call customer that does not exist

PS C:\Users\somed\java-bootcamp\module-08-lab8> java -cp target\classes com.northstar.crm.FailureExperiment
Exception in thread "main" java.lang.UnsupportedOperationException: TODO: Lab 8 stub findById
at com.northstar.crm.repository.CustomerRepository.findById(CustomerRepository.java:16)
at com.northstar.crm.FailureExperiment.main(FailureExperiment.java:8)

did not work, looked forfindByID but was unable to get it(since it doesnt exist)

test 3:
Compile twice:

worked both times, built without problem