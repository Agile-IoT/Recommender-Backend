/**
 * @apiDescription AGILE Recommender and Configurator API Definitions.
 * @apiVersion 0.0.2
 *
 */

/**
 * @apiDefine NoRecommendationFound
 *
 * @apiError NoRecommendationFound For this gateway no recommendation can be found.
 *
 * @apiErrorExample Error-Response:
 *     HTTP/1.1 404 Not Found
 *     {
 *       "error": "No Recommendation Found"
 *     }
 */


/**
 * @api {post} http://54.213.147.198:8080/recommender/getAppRecomm Recommend App
 * @apiVersion 0.0.2
 * @apiName getAppRecomm
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Management UI. It returns App Recommendation Results based on hybrid techiques(Content Based and Collaborative Fileting)
 *
 * @apiParam {long} userID			userID.
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 *
 * @apiSuccess {String} title      Title of the recomended App.
 * @apiSuccess {String} href	   Link of sthe App.
 *
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *  	"userID":1,	
 *   	"devices":"temperature",
 *   	"apps":"",
 *   	"wfs":"" ,
 *      "resources":""
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * [
 *     {
 *         "title": "IoT@home",
 *         "href": "/store/apps/details?id=com.lguplus.homeiot"
 *     },
 *     {
 *         "title": "IoT Manager",
 *         "href": "/store/apps/details?id=ru.esp8266.iotmanager"
 *     },
 *     {
 *         "title": "Meat Temperature Guide",
 *         "href": "/store/apps/details?id=gianouts.android.meattemperature"
 *     },
 *     {
 *         "title": "Ambient Temperature & Humidity",
 *         "href": "/store/apps/details?id=com.sensirion.ambientsensing"
 *     },
 *     {
 *         "title": "IoT Handbook",
 *         "href": "/store/apps/details?id=com.app.p7620EA"
 *     },
 *     {
 *         "title": "IoT MQTT Dashboard",
 *         "href": "/store/apps/details?id=com.thn.iotmqttdashboard"
 *     },
 *     {
 *         "title": "Cpu Temperature",
 *         "href": "/store/apps/details?id=com.yanyan.cputemp"
 *     },
 *     {
 *         "title": "Temperature Metric Converter",
 *         "href": "/store/apps/details?id=com.danielfritzsch.temperatureconverter"
 *     },
 *     {
 *         "title": "Ambient Temperature - Galaxy",
 *         "href": "/store/apps/details?id=com.envyandroid.tempsens"
 *     },
 *     {
 *         "title": "Oven Temperature Convertor",
 *         "href": "/store/apps/details?id=appinventor.ai_johnmollaghan.OvenTemperatoreConvertor"
 *     }
 * ]

 * @apiUse NoRecommendationFound
 */

/**
 * @api {post} http://54.213.147.198:8080/recommender/getWFRecomm Recommend Workflow
 * @apiVersion 0.0.2
 * @apiName getWFRecomm
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Development UI. It returns Workflow Recommendation Results based on hybrid techiques(Content Based and Collaborative Fileting)
 *
 * @apiParam {long} userID			userID.
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 * 
 * 
 * @apiSuccess {String} type	   node or workflow.
 * @apiSuccess {String} datatag	   tags of node or workflow.
 * @apiSuccess {String} dataowner  developer's name.
 * @apiSuccess {String} href	   link of the node or workflow.
 *
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *  	"userID":1,	
 *   	"devices":"temperature",
 *   	"apps":"",
 *   	"wfs":"" ,
 *      "resources":""
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * [
 *     {
 *         "type": "node",
 *         "datatag": "node-red,soap,wsdl,ibm",
 *         "dataowner": "Neil Kolban",
 *         "href": "/node/node-red-contrib-soapserver"
 *     },
 *    {
 *         "type": "node",
 *         "datatag": "node-red,ibm,connections,profiles,status,update",
 *         "dataowner": "",
 *         "href": "/node/node-red-ibmconnections"
 *     },
 *     {
 *         "type": "flow",
 *         "datatag": "IoT,cloudant,nodered,IBM,bluemix",
 *         "dataowner": "bsilverm",
 *         "href": "/flow/7d4b5c1189c8f5df3a1f"
 *     },
 *     {
 *         "type": "node",
 *         "datatag": "node-red,tinkerpop,graphdb,gremlin,ibm",
 *         "dataowner": "Sam Adams",
 *         "href": "/node/node-red-contrib-tinkerpop"
 *     },
 *     {
 *         "type": "node",
 *         "datatag": "node-red,ads-b,dump1090,ibm",
 *         "dataowner": "Neil Kolban",
 *         "href": "/node/node-red-contrib-ads-b"
 *     },
 *     {
 *         "type": "node",
 *         "datatag": "IBM,node-red,sensor,ble",
 *         "dataowner": "Cristian Traistaru",
 *         "href": "/node/node-red-contrib-sensortag"
 *     },s
 *     {
 *         "type": "flow",
 *         "datatag": "SensorTag,TI,Bluemix,IoT,IBM,Simplelink",
 *         "dataowner": "uwefassnacht",
 *         "href": "/flow/0d458526303cfea9479d"
 *     },
 *     {
 *         "type": "node",
 *         "datatag": "node-red,couchdb,ibm",
 *         "dataowner": "Neil Kolban",
 *         "href": "/node/node-red-contrib-couchdb"
 *     },
 *     {
 *         "type": "node",
 *         "datatag": "node-red,ibm,flightaware",
 *         "dataowner": "Rob Peeren",
 *         "href": "/node/node-red-contrib-flightaware"
 *     },
 *     {
 *         "type": "node",
 *        "datatag": "node-red,bluemix,watson,iot,ibm",
 *         "dataowner": "Nick O'Leary",
 *         "href": "/node/node-red-contrib-ibm-watson-iot"
 *     }
 * ]
 * @apiUse NoRecommendationFound
 */

/**
 * @api {post} http://54.213.147.198:8080/recommender/getDevRecomm Recommend Device
 * @apiVersion 0.0.1
 * @apiName getDevRecomm
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Management UI. It returns Device Recommendation Results based on Content Based Filtering.
 *
 * @apiParam {long} userID			userID.
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 * 
 * 
 * @apiSuccess {String} type	   device type.
 * @apiSuccess {String} href	   link of the device to buy.
 *
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *  	"userID":1,	
 *   	"devices":"temperature",
 *   	"apps":"",
 *   	"wfs":"/node/node-red-contrib-sensortag" ,
 *      "resources":""
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * [
 *     {
 *         "type": "gassensor",
 *         "href": "http://agiledevicemarketplace/sensors/gassensor"
 *     }
 * ]
 * @apiUse NoRecommendationFound
 */

 /**
 * @api {post} http://54.213.147.198:8080/recommender/getCloudRecomm Recommend Cloud Solution 
 * @apiVersion 0.0.1
 * @apiName getCloudRecomm
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Management UI. It returns Cloud Solution Recommendation Results.
 *
 * @apiParam {long} userID			userID.
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 * 
 * 
 * @apiSuccess {String} type	   device type.
 * @apiSuccess {String} href	   link of the device to buy.
 *
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *  	"userID":1,	
 *   	"devices":"temperature",
 *   	"apps":"",
 *   	"wfs":"" ,
 *      "resources":""
 * }
 * 
* RESPONSE:
* HTTP/1.1 200 OK
* [
*   {
*        "cloudname": "Bluemix",
*        "href": https://console.ng.bluemix.net/,
*        "type": "public and private",
*        "serverlocations": "EU, NA, OC",
*        "explanation": "On Bluemix, you deploy and run your workflows"
*    },
* ]
*
* @apiUse NoRecommendationFound
*/
 

  /**
 * @api {post} http://54.213.147.198:8080/recommender/addApp Add a new App
 * @apiVersion 0.0.1
 * @apiName addApp
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It adds a new App to the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
* REQUEST:
* {
*         "title": "IoT@home",
*         "href": "/store/apps/details?id=com.lguplus.homeiot"
*          "UserRatings":{
*                           {"UserID": "12132353535 ",
*                            "Rating": "3"},
*                           {"UserID": "56765765765 ",
*                            "Rating": "1"},
*                        }
* }
* 
* RESPONSE:
* HTTP/1.1 200 OK
* 
 */
   /**
 * @api {post} http://54.213.147.198:8080/recommender/deleteApp Delete an App 
 * @apiVersion 0.0.1
 * @apiName deleteApp
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It deletes an App from the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
* REQUEST:
* {
*         "title": "IoT@home",
*         "href": "/store/apps/details?id=com.lguplus.homeiot"
* }
* 
* RESPONSE:
* HTTP/1.1 200 OK
* 
 */

   /**
 * @api {post} http://54.213.147.198:8080/recommender/updateApp Update an App 
 * @apiVersion 0.0.1
 * @apiName updateApp
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It updates an App on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "title": "IoT@home",
 *         "href": "/store/apps/details?id=com.lguplus.homeiot"
 *          "UserRatings": {
 *                              {"UserID": "12132353535 ",
 *                               "Rating": "3"},
 *                              {"UserID": "56765765765 ",
 *                               "Rating": "1"},
 *                              {"UserID": "45545345343 ",
 *                                "Rating": "5"},
 *                         }
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

 /**
 * @api {post} http://54.213.147.198:8080/recommender/addWF  Add a new Workflow 
 * @apiVersion 0.0.1
 * @apiName addWF
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "node",
 *         "datatag": "node-red,bluemix,watson,iot,ibm",
 *         "dataowner": "Nick O'Leary",
 *         "href": "/node/node-red-contrib-ibm-watson-iot"
 *          "UserRatings":     {
 *                                             {"UserID": "12132353535 ",
 *                                              "Rating": "5"},
 *                                              {"UserID": "56765765765 ",
 *                                              "Rating": "5"}
 *                                        }
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 *
 */
 /**
 * @api {post} http://54.213.147.198:8080/recommender/deleteWF  Delete a Workflow 
 * @apiVersion 0.0.1
 * @apiName deleteWF
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "node",
 *         "href": "/node/node-red-contrib-ibm-watson-iot"
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 *
 */
  /**
 * @api {post} http://54.213.147.198:8080/recommender/updateWF  Update a Workflow 
 * @apiVersion 0.0.1
 * @apiName updateWF
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "node",
 *         "datatag": "node-red,bluemix,watson,iot,ibm",
 *         "dataowner": "Nick O'Leary",
 *         "href": "/node/node-red-contrib-ibm-watson-iot"
 *          "UserRatings":     {
 *                                             	{"UserID": "12132353535 ",
 *                                              "Rating": "5"},
 *                                             	{"UserID": "56765765765 ",
 *                                              "Rating": "5"},
 *												{"UserID": "45545345343 ",
 *                                           	"Rating": "1"}
 *
 *                                        }
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 *
 */
 
 /**
 * @api {post} http://54.213.147.198:8080/recommender/addDev Add a new Device 
 * @apiVersion 0.0.1
 * @apiName addDev
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace UI. It adds Device Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "gassensor",
 *         "href": "http://agiledevicemarketplace/sensors/gassensor"
 *          "UserRatings":     {
 *                                             	{"UserID": "12132353535 ",
 *                                              "Rating": "5"},
 *                                             	{"UserID": "56765765765 ",
 *                                              "Rating": "5"}
 *
 *                                        }
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

/**
 * @api {post} http://54.213.147.198:8080/recommender/deleteDev Delete a Device 
 * @apiVersion 0.0.1
 * @apiName deleteDev
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace UI. It deletes Device Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "gassensor",
 *         "href": "http://agiledevicemarketplace/sensors/gassensor"
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

  /**
 * @api {post} http://54.213.147.198:8080/recommender/updateDev Update a Device 
 * @apiVersion 0.0.1
 * @apiName updateDev
 * @apiGroup Recommender
 * @apiDescription This API is called by AGILE Merketplace UI. It adds Device Marketplace on the Recommender/Configurator server.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "type": "gassensor",
 *         "href": "http://agiledevicemarketplace/sensors/gassensor"
 *          "UserRatings":     {
 *                                             	{"UserID": "12132353535 ",
 *                                              "Rating": "5"},
 *                                             	{"UserID": "56765765765 ",
 *                                              "Rating": "5"},
 *												{"UserID": "45545345343 ",
 *                                            	"Rating": "1"}
 *
 *                                        }
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

 /**
 * @api {post} http://54.213.147.198:8080/configurator/getRampupConf Get Ramp-up Configurations
 * @apiVersion 0.0.1
 * @apiName getRampupConf
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Management UI. It returns Configurations of the ramp-up settings for mentioned configurator. 
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "configurator": "Pilot-C",
 *         "userrequirements": "yes,no,5000,5,no,yes,yes,3,10000"
 * }
 * 
* RESPONSE:
* HTTP/1.1 200 OK
*
* {
*        "configurationresult": " "numberofsensors:7", "connection:3G", "cost:6850" ",
* }
 * 
 */

/**
 * @api {post} http://54.213.147.198:8080/configurator/addRampupConf Add a new Ramp-up Configurator
 * @apiVersion 0.0.1
 * @apiName addRampupConf
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Management UI. It adds a new Ramp-up Configurator. 
 * @apiSuccessExample Sample Request-Reponse:2
 * REQUEST:
 * {
 *         "configurator": "SmartHome",
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

 /**
 * @api {post} http://54.213.147.198:8080/configurator/deleteRampupConf Delete a Ramp-up Configurator
 * @apiVersion 0.0.1
 * @apiName deleteRampupConf
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Management UI. It deletes a Ramp-up Configurator. 
 * @apiSuccessExample Sample Request-Reponse:2
 * REQUEST:
 * {
 *         "configurator": "SmartHome",
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

 /**
 * @api {post} http://54.213.147.198:8080/configurator/addRampupCons Add new Ramp-up Constraints
 * @apiVersion 0.0.1
 * @apiName addRampupCons
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Management UI. It adds new Ramp-up Constraints to the ramp-up settings for mentioned constraints. 
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "configurator": "SmartHome",
 *         "newconstraints": " % simplified configuration knowledge base from smarthome domain
 *  						% component instances
 *  						kitchen_domain(2). living_room_domain(3).
 *  						% domain generalizations
 * 							room_domain(X):-kitchen_domain(X).
 * 							room_domain(X):-living_room_domain(X).
 * 							% component types
 * 							kitchen(X):-kitchen_domain(X).
 * 							living_room(X):-living_room_domain(X).
 * 							% attribute domains (here: kitchen has heatsensor)
 * 							heatsensor(X,false):-living_room(X).
 * 							heatsensor(X,true):-kitchen(X).
 * 							% generalization hierarchies
 * 							room(X):-kitchen(X).
 * 							room(X):-living_room(X).
 * 							% customer requirements
 * 							room(2).
 * 							%room(3).
 * 							% configuration result
 * 							%kitchen(2) living_room(3) heatsensor(3,false) 
 * 							heatsensor(2,true)  "
 * }
 * 
 * RESPONSE:
 * HTTP/1.1 200 OK
 * 
 */

 /**
 * @api {post} http://54.213.147.198:8080/configurator/getRampupCons Get Ramp-up Constraints
 * @apiVersion 0.0.1
 * @apiName getRampupCons
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Management UI. It returns the constraints of the ramp-up settings for mentioned configurator. 
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *         "configurator": "SmartHome",
 *        
 * }
 * 
* RESPONSE:
* HTTP/1.1 200 OK
*
* {
*         "configurator": "SmartHome",
*         "constraints": " % simplified configuration knowledge base from smarthome domain
 *  						% component instances
 *  						kitchen_domain(2). living_room_domain(3).
 *  						% domain generalizations
 * 							room_domain(X):-kitchen_domain(X).
 * 							room_domain(X):-living_room_domain(X).
 * 							% component types
 * 							kitchen(X):-kitchen_domain(X).
 * 							living_room(X):-living_room_domain(X).
 * 							% attribute domains (here: kitchen has heatsensor)
 * 							heatsensor(X,false):-living_room(X).
 * 							heatsensor(X,true):-kitchen(X).
 * 							% generalization hierarchies
 * 							room(X):-kitchen(X).
 * 							room(X):-living_room(X).
 * 							% customer requirements
 * 							room(2).
 * 							%room(3).
 * 							% configuration result
 * 							%kitchen(2) living_room(3) heatsensor(3,false) 
 * 							heatsensor(2,true)  "
* }
 * 
 */


 /**
 * @api {post} http://127.0.0.1:8080/configurator/getResourceOptimization Get ResourceOptimization Configurations 
 * @apiVersion 0.0.1
 * @apiName getResOptConfiguration
 * @apiGroup Configurator
 * @apiDescription This API is called by AGILE Gateway Software/OS. It returns Configurations of resource optimization of the gateway.
 * @apiSuccessExample Sample Request-Reponse:
 * REQUEST:
 * {
 *          "Apps": {
 *                     { "name": "FitnessApp",
 *                       "data encoding protocols-selective": "XML, JSON",
 *                       "network protocols-selective": "Zigbee, NFC, BLE"},
 *                     { "name": "WhereisMyPet",
 *                       "data encoding protocols-selective": "JSON",
 *                       "network protocols-selective": "BLE, Zigbee"},
 *                   },
 *          "Devices":{ "NFC enabler", "BLE enabler", "Zigbee enabler", "Temperature Sensor"} ,
 *			"AvailableResources": { "power": "BatterMode: 67",
 *                        "memory": "120 MB",
 *                        "storage": "5.3 GB"
 *                      }
 *			"Preferences": { "power": "battery saving mode: Enabled",
 *                           "dataexchange": "minimize: Enabled",
 *                         }
 * }
 * 
* RESPONSE:
* HTTP/1.1 200 OK
*
* {
*        "networkprotocols": {"BLE"} ,
*        "dataencodingprotocols": {"JSON"} ,
* }
* 
*/

