# QA_Automation_Povio_Assignment

TO install this you need to download the .git file from the repo by conin the repo or downloading the zipfile

  Requirements: 
    1. Maven installed and Maven home as a envirement variable.
    
    
  To run the required test you need to move to the projects directory via terminal or tools that are used to run Maven applications
   1. Once you moved to the projects directory
   2. You need to invoce the maven goals by running the comands:
   
       mvn verify -Dcucumber.options="--tags @newCampaign"  to create a new Campaign
       
        mvn verify -Dcucumber.options="--tags @editCampaign"  to edit an existing Campaign
        
        mvn verify -Dcucumber.options="--tags @newusercreate"  to register random users// this generates a new random user everytime
       
        mvn verify -Dcucumber.options="--tags @checkuniqness"  to verify thatyou cannot register with an already existing email
        
        mvn verify -Dcucumber.options="--tags @signin"  to sign in
        
        mvn verify -Dcucumber.options="--tags @deleteacc"  to delete an account
        
        mvn verify -Dcucumber.options="--tags @health"  to perform a smoke test/health test
          
      **THis framework can genrate reports and screen shots whenever a test or a scenario fails** 
