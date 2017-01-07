# Recommender
## Recommender Service on AGILE Gateway

AGILE Recommender Service runs on server side.

Provides 3 restful services: 
* /getAppRecommendation
* /getWorkflowRecommendation
* /getCloudRecommendation


Example Input and Output:

```
{
 	"userID":1,	
  	"devices":"",
  	"apps":"",
  	"wfs":"" ,
    "resources":"",
    "location": "EU",
    "pricingPreferences": "free OR metered"
}
```

```
[
    {
        "title": "Heroku ",
        "link": "https://www.heroku.com/ ",
        "accesstype": "public , private ",
        "locations": "EU , NA ",
        "middlewares": "m ",
        "frameworks": "django , flask , grails , play , rails ",
        "runtimes": "clojue , go , groovyjava , node , php , python , ruby , scala ",
        "services": "postgresql , redis , TODO_ADD_MORE ",
        "pricing": "metered , monthly , free "
    },
    {
        "title": "OpenShift Online ",
        "link": "https://www.openshift.com/features/index.html ",
        "accesstype": "public , private ",
        "locations": "EU , NA ",
        "middlewares": "jboss , tomcat , zend server ",
        "frameworks": "django , drupal , flask , rails , switchyard , vert.x ",
        "runtimes": "java , node , perl , php , python , ruby ",
        "services": "jenkins , mongodb , mysql , openshift metrics , postgresql ",
        "pricing": "monthly , fixed , annually , free , hybrid "
    },
    {
        "title": "Bluemix ",
        "link": "https://console.ng.bluemix.net/ ",
        "accesstype": "public , private ",
        "locations": "EU , NA , OC ",
        "middlewares": "m ",
        "frameworks": "rails , sinatra ",
        "runtimes": "go , java , node , php , python , ruby ",
        "services": "advancedd mobile access ,  alchemyapi ,  api management ,  application security manager ,  appscan dynamis analyzer ,  appscan mobile analyzer ,  TODO_ADD_MORE ",
        "pricing": "metered , monthly "
    },
    {
        "title": "Microsoft Azure ",
        "link": "https://azure.microsoft.com/tr-tr/ ",
        "accesstype": "public ",
        "locations": "AS , EU , NA , OC , SA ",
        "middlewares": "tomcat ",
        "frameworks": "cakephp , django ",
        "runtimes": "dotnet , java , node , php , python , ruby ",
        "services": "TODO_ADD_MORE ",
        "pricing": "metered , monthly "
    },
    {
        "title": "Atos Cloud Foundry ",
        "link": "https://canopy-cloud.com/application-platforms/atos-cloud-foundry ",
        "accesstype": "public , private ",
        "locations": "AS , EU , NA , OC , SA ",
        "middlewares": "jboss , tomcat , tomee ",
        "frameworks": "django , grails , hhvm , play , rack , rails , sinatra , spring ",
        "runtimes": "clojure , dotnet , go , groovy , java , node , php , python , ruby , scala , swift ",
        "services": "neo4j , abacus , cassandra , couchdb , dingo-postgresql , elasticsearch , kafka , memcached , mongodb , mysql , postgresql , rabbitmq , redis , riakcs ,  TODO_ADD_MORE ",
        "pricing": "metered , monthly , fixed "
    }
]
```