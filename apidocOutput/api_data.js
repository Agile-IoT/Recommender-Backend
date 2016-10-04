define({ "api": [
  {
    "description": "<p>AGILE Recommender and Configurator API Definitions.</p>",
    "version": "0.0.2",
    "type": "",
    "url": "",
    "filename": "apidocInput/apidoc.js",
    "group": "C__Users_spolater_github_agile_Recommender_Recommender_apidocInput_apidoc_js",
    "groupTitle": "C__Users_spolater_github_agile_Recommender_Recommender_apidocInput_apidoc_js",
    "name": ""
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/configurator/addRampupConf",
    "title": "Add a new Ramp-up Configurator",
    "version": "0.0.1",
    "name": "addRampupConf",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Management UI. It adds a new Ramp-up Configurator.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:2",
          "content": "REQUEST:\n{\n        \"configurator\": \"SmartHome\",\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/configurator/addRampupCons",
    "title": "Add new Ramp-up Constraints",
    "version": "0.0.1",
    "name": "addRampupCons",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Management UI. It adds new Ramp-up Constraints to the ramp-up settings for mentioned constraints.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"configurator\": \"SmartHome\",\n        \"newconstraints\": \" % simplified configuration knowledge base from smarthome domain\n \t\t\t\t\t\t% component instances\n \t\t\t\t\t\tkitchen_domain(2). living_room_domain(3).\n \t\t\t\t\t\t% domain generalizations\n\t\t\t\t\t\t\troom_domain(X):-kitchen_domain(X).\n\t\t\t\t\t\t\troom_domain(X):-living_room_domain(X).\n\t\t\t\t\t\t\t% component types\n\t\t\t\t\t\t\tkitchen(X):-kitchen_domain(X).\n\t\t\t\t\t\t\tliving_room(X):-living_room_domain(X).\n\t\t\t\t\t\t\t% attribute domains (here: kitchen has heatsensor)\n\t\t\t\t\t\t\theatsensor(X,false):-living_room(X).\n\t\t\t\t\t\t\theatsensor(X,true):-kitchen(X).\n\t\t\t\t\t\t\t% generalization hierarchies\n\t\t\t\t\t\t\troom(X):-kitchen(X).\n\t\t\t\t\t\t\troom(X):-living_room(X).\n\t\t\t\t\t\t\t% customer requirements\n\t\t\t\t\t\t\troom(2).\n\t\t\t\t\t\t\t%room(3).\n\t\t\t\t\t\t\t% configuration result\n\t\t\t\t\t\t\t%kitchen(2) living_room(3) heatsensor(3,false) \n\t\t\t\t\t\t\theatsensor(2,true)  \"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/configurator/deleteRampupConf",
    "title": "Delete a Ramp-up Configurator",
    "version": "0.0.1",
    "name": "deleteRampupConf",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Management UI. It deletes a Ramp-up Configurator.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:2",
          "content": "REQUEST:\n{\n        \"configurator\": \"SmartHome\",\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/configurator/getRampupConf",
    "title": "Get Ramp-up Configurations",
    "version": "0.0.1",
    "name": "getRampupConf",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Management UI. It returns Configurations of the ramp-up settings for mentioned configurator.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"configurator\": \"Pilot-C\",\n        \"userrequirements\": \"yes,no,5000,5,no,yes,yes,3,10000\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n\n{\n       \"configurationresult\": \" \"numberofsensors:7\", \"connection:3G\", \"cost:6850\" \",\n}",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/configurator/getRampupCons",
    "title": "Get Ramp-up Constraints",
    "version": "0.0.1",
    "name": "getRampupCons",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Management UI. It returns the constraints of the ramp-up settings for mentioned configurator.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"configurator\": \"SmartHome\",\n       \n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n\n{\n        \"configurator\": \"SmartHome\",\n        \"constraints\": \" % simplified configuration knowledge base from smarthome domain\n \t\t\t\t\t\t% component instances\n \t\t\t\t\t\tkitchen_domain(2). living_room_domain(3).\n \t\t\t\t\t\t% domain generalizations\n\t\t\t\t\t\t\troom_domain(X):-kitchen_domain(X).\n\t\t\t\t\t\t\troom_domain(X):-living_room_domain(X).\n\t\t\t\t\t\t\t% component types\n\t\t\t\t\t\t\tkitchen(X):-kitchen_domain(X).\n\t\t\t\t\t\t\tliving_room(X):-living_room_domain(X).\n\t\t\t\t\t\t\t% attribute domains (here: kitchen has heatsensor)\n\t\t\t\t\t\t\theatsensor(X,false):-living_room(X).\n\t\t\t\t\t\t\theatsensor(X,true):-kitchen(X).\n\t\t\t\t\t\t\t% generalization hierarchies\n\t\t\t\t\t\t\troom(X):-kitchen(X).\n\t\t\t\t\t\t\troom(X):-living_room(X).\n\t\t\t\t\t\t\t% customer requirements\n\t\t\t\t\t\t\troom(2).\n\t\t\t\t\t\t\t%room(3).\n\t\t\t\t\t\t\t% configuration result\n\t\t\t\t\t\t\t%kitchen(2) living_room(3) heatsensor(3,false) \n\t\t\t\t\t\t\theatsensor(2,true)  \"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://127.0.0.1:8080/configurator/getResourceOptimization",
    "title": "Get ResourceOptimization Configurations",
    "version": "0.0.1",
    "name": "getResOptConfiguration",
    "group": "Configurator",
    "description": "<p>This API is called by AGILE Gateway Software/OS. It returns Configurations of resource optimization of the gateway.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n         \"Apps\": {\n                    { \"name\": \"FitnessApp\",\n                      \"data encoding protocols-selective\": \"XML, JSON\",\n                      \"network protocols-selective\": \"Zigbee, NFC, BLE\"},\n                    { \"name\": \"WhereisMyPet\",\n                      \"data encoding protocols-selective\": \"JSON\",\n                      \"network protocols-selective\": \"BLE, Zigbee\"},\n                  },\n         \"Devices\":{ \"NFC enabler\", \"BLE enabler\", \"Zigbee enabler\", \"Temperature Sensor\"} ,\n\t\t\t\"AvailableResources\": { \"power\": \"BatterMode: 67\",\n                       \"memory\": \"120 MB\",\n                       \"storage\": \"5.3 GB\"\n                     }\n\t\t\t\"Preferences\": { \"power\": \"battery saving mode: Enabled\",\n                          \"dataexchange\": \"minimize: Enabled\",\n                        }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n\n{\n       \"networkprotocols\": {\"BLE\"} ,\n       \"dataencodingprotocols\": {\"JSON\"} ,\n}",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Configurator"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/addApp",
    "title": "Add a new App",
    "version": "0.0.1",
    "name": "addApp",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It adds a new App to the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"title\": \"IoT@home\",\n        \"href\": \"/store/apps/details?id=com.lguplus.homeiot\"\n         \"UserRatings\":{\n                          {\"UserID\": \"12132353535 \",\n                           \"Rating\": \"3\"},\n                          {\"UserID\": \"56765765765 \",\n                           \"Rating\": \"1\"},\n                       }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/addDev",
    "title": "Add a new Device",
    "version": "0.0.1",
    "name": "addDev",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace UI. It adds Device Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"gassensor\",\n        \"href\": \"http://agiledevicemarketplace/sensors/gassensor\"\n         \"UserRatings\":     {\n                                            \t{\"UserID\": \"12132353535 \",\n                                             \"Rating\": \"5\"},\n                                            \t{\"UserID\": \"56765765765 \",\n                                             \"Rating\": \"5\"}\n\n                                       }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/addWF",
    "title": "Add a new Workflow",
    "version": "0.0.1",
    "name": "addWF",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"node\",\n        \"datatag\": \"node-red,bluemix,watson,iot,ibm\",\n        \"dataowner\": \"Nick O'Leary\",\n        \"href\": \"/node/node-red-contrib-ibm-watson-iot\"\n         \"UserRatings\":     {\n                                            {\"UserID\": \"12132353535 \",\n                                             \"Rating\": \"5\"},\n                                             {\"UserID\": \"56765765765 \",\n                                             \"Rating\": \"5\"}\n                                       }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/deleteApp",
    "title": "Delete an App",
    "version": "0.0.1",
    "name": "deleteApp",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It deletes an App from the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"title\": \"IoT@home\",\n        \"href\": \"/store/apps/details?id=com.lguplus.homeiot\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/deleteDev",
    "title": "Delete a Device",
    "version": "0.0.1",
    "name": "deleteDev",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace UI. It deletes Device Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"gassensor\",\n        \"href\": \"http://agiledevicemarketplace/sensors/gassensor\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/deleteWF",
    "title": "Delete a Workflow",
    "version": "0.0.1",
    "name": "deleteWF",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"node\",\n        \"href\": \"/node/node-red-contrib-ibm-watson-iot\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/getAppRecomm",
    "title": "Recommend App",
    "version": "0.0.2",
    "name": "getAppRecomm",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Management UI. It returns App Recommendation Results based on hybrid techiques(Content Based and Collaborative Fileting)</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "userID",
            "description": "<p>userID.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedApps",
            "description": "<p>installed apps on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pluggedDevs",
            "description": "<p>plugged devices on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedWFs",
            "description": "<p>installed nodes on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "resources",
            "description": "<p>remaining resources of the gateway.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>Title of the recomended App.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>Link of sthe App.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n \t\"userID\":1,\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n     \"resources\":\"\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n[\n    {\n        \"title\": \"IoT@home\",\n        \"href\": \"/store/apps/details?id=com.lguplus.homeiot\"\n    },\n    {\n        \"title\": \"IoT Manager\",\n        \"href\": \"/store/apps/details?id=ru.esp8266.iotmanager\"\n    },\n    {\n        \"title\": \"Meat Temperature Guide\",\n        \"href\": \"/store/apps/details?id=gianouts.android.meattemperature\"\n    },\n    {\n        \"title\": \"Ambient Temperature & Humidity\",\n        \"href\": \"/store/apps/details?id=com.sensirion.ambientsensing\"\n    },\n    {\n        \"title\": \"IoT Handbook\",\n        \"href\": \"/store/apps/details?id=com.app.p7620EA\"\n    },\n    {\n        \"title\": \"IoT MQTT Dashboard\",\n        \"href\": \"/store/apps/details?id=com.thn.iotmqttdashboard\"\n    },\n    {\n        \"title\": \"Cpu Temperature\",\n        \"href\": \"/store/apps/details?id=com.yanyan.cputemp\"\n    },\n    {\n        \"title\": \"Temperature Metric Converter\",\n        \"href\": \"/store/apps/details?id=com.danielfritzsch.temperatureconverter\"\n    },\n    {\n        \"title\": \"Ambient Temperature - Galaxy\",\n        \"href\": \"/store/apps/details?id=com.envyandroid.tempsens\"\n    },\n    {\n        \"title\": \"Oven Temperature Convertor\",\n        \"href\": \"/store/apps/details?id=appinventor.ai_johnmollaghan.OvenTemperatoreConvertor\"\n    }\n]",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender",
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoRecommendationFound",
            "description": "<p>For this gateway no recommendation can be found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"No Recommendation Found\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/getCloudRecomm",
    "title": "Recommend Cloud Solution",
    "version": "0.0.1",
    "name": "getCloudRecomm",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Management UI. It returns Cloud Solution Recommendation Results.</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "userID",
            "description": "<p>userID.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedApps",
            "description": "<p>installed apps on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pluggedDevs",
            "description": "<p>plugged devices on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedWFs",
            "description": "<p>installed nodes on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "resources",
            "description": "<p>remaining resources of the gateway.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>device type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>link of the device to buy.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n \t\"userID\":1,\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n     \"resources\":\"\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n[\n  {\n       \"cloudname\": \"Bluemix\",\n       \"href\": https://console.ng.bluemix.net/,\n       \"type\": \"public and private\",\n       \"serverlocations\": \"EU, NA, OC\",\n       \"explanation\": \"On Bluemix, you deploy and run your workflows\"\n   },\n]",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender",
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoRecommendationFound",
            "description": "<p>For this gateway no recommendation can be found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"No Recommendation Found\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/getDevRecomm",
    "title": "Recommend Device",
    "version": "0.0.1",
    "name": "getDevRecomm",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Management UI. It returns Device Recommendation Results based on Content Based Filtering.</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "userID",
            "description": "<p>userID.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedApps",
            "description": "<p>installed apps on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pluggedDevs",
            "description": "<p>plugged devices on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedWFs",
            "description": "<p>installed nodes on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "resources",
            "description": "<p>remaining resources of the gateway.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>device type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>link of the device to buy.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n \t\"userID\":1,\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"/node/node-red-contrib-sensortag\" ,\n     \"resources\":\"\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n[\n    {\n        \"type\": \"gassensor\",\n        \"href\": \"http://agiledevicemarketplace/sensors/gassensor\"\n    }\n]",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender",
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoRecommendationFound",
            "description": "<p>For this gateway no recommendation can be found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"No Recommendation Found\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/getWFRecomm",
    "title": "Recommend Workflow",
    "version": "0.0.2",
    "name": "getWFRecomm",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Development UI. It returns Workflow Recommendation Results based on hybrid techiques(Content Based and Collaborative Fileting)</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "userID",
            "description": "<p>userID.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedApps",
            "description": "<p>installed apps on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pluggedDevs",
            "description": "<p>plugged devices on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "installedWFs",
            "description": "<p>installed nodes on the gateway.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "resources",
            "description": "<p>remaining resources of the gateway.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>node or workflow.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "datatag",
            "description": "<p>tags of node or workflow.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dataowner",
            "description": "<p>developer's name.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>link of the node or workflow.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n \t\"userID\":1,\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n     \"resources\":\"\"\n}\n\nRESPONSE:\nHTTP/1.1 200 OK\n[\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,soap,wsdl,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-soapserver\"\n    },\n   {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ibm,connections,profiles,status,update\",\n        \"dataowner\": \"\",\n        \"href\": \"/node/node-red-ibmconnections\"\n    },\n    {\n        \"type\": \"flow\",\n        \"datatag\": \"IoT,cloudant,nodered,IBM,bluemix\",\n        \"dataowner\": \"bsilverm\",\n        \"href\": \"/flow/7d4b5c1189c8f5df3a1f\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,tinkerpop,graphdb,gremlin,ibm\",\n        \"dataowner\": \"Sam Adams\",\n        \"href\": \"/node/node-red-contrib-tinkerpop\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ads-b,dump1090,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-ads-b\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"IBM,node-red,sensor,ble\",\n        \"dataowner\": \"Cristian Traistaru\",\n        \"href\": \"/node/node-red-contrib-sensortag\"\n    },s\n    {\n        \"type\": \"flow\",\n        \"datatag\": \"SensorTag,TI,Bluemix,IoT,IBM,Simplelink\",\n        \"dataowner\": \"uwefassnacht\",\n        \"href\": \"/flow/0d458526303cfea9479d\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,couchdb,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-couchdb\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ibm,flightaware\",\n        \"dataowner\": \"Rob Peeren\",\n        \"href\": \"/node/node-red-contrib-flightaware\"\n    },\n    {\n        \"type\": \"node\",\n       \"datatag\": \"node-red,bluemix,watson,iot,ibm\",\n        \"dataowner\": \"Nick O'Leary\",\n        \"href\": \"/node/node-red-contrib-ibm-watson-iot\"\n    }\n]",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender",
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NoRecommendationFound",
            "description": "<p>For this gateway no recommendation can be found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"No Recommendation Found\"\n}",
          "type": "json"
        }
      ]
    }
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/updateApp",
    "title": "Update an App",
    "version": "0.0.1",
    "name": "updateApp",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It updates an App on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"title\": \"IoT@home\",\n        \"href\": \"/store/apps/details?id=com.lguplus.homeiot\"\n         \"UserRatings\": {\n                             {\"UserID\": \"12132353535 \",\n                              \"Rating\": \"3\"},\n                             {\"UserID\": \"56765765765 \",\n                              \"Rating\": \"1\"},\n                             {\"UserID\": \"45545345343 \",\n                               \"Rating\": \"5\"},\n                        }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/updateDev",
    "title": "Update a Device",
    "version": "0.0.1",
    "name": "updateDev",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace UI. It adds Device Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"gassensor\",\n        \"href\": \"http://agiledevicemarketplace/sensors/gassensor\"\n         \"UserRatings\":     {\n                                            \t{\"UserID\": \"12132353535 \",\n                                             \"Rating\": \"5\"},\n                                            \t{\"UserID\": \"56765765765 \",\n                                             \"Rating\": \"5\"},\n\t\t\t\t\t\t\t\t\t\t\t\t{\"UserID\": \"45545345343 \",\n                                           \t\"Rating\": \"1\"}\n\n                                       }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  },
  {
    "type": "post",
    "url": "http://54.213.147.198:8080/recommender/updateWF",
    "title": "Update a Workflow",
    "version": "0.0.1",
    "name": "updateWF",
    "group": "Recommender",
    "description": "<p>This API is called by AGILE Merketplace. It adds Workflow Marketplace on the Recommender/Configurator server.</p>",
    "success": {
      "examples": [
        {
          "title": "Sample Request-Reponse:",
          "content": "REQUEST:\n{\n        \"type\": \"node\",\n        \"datatag\": \"node-red,bluemix,watson,iot,ibm\",\n        \"dataowner\": \"Nick O'Leary\",\n        \"href\": \"/node/node-red-contrib-ibm-watson-iot\"\n         \"UserRatings\":     {\n                                            \t{\"UserID\": \"12132353535 \",\n                                             \"Rating\": \"5\"},\n                                            \t{\"UserID\": \"56765765765 \",\n                                             \"Rating\": \"5\"},\n\t\t\t\t\t\t\t\t\t\t\t\t{\"UserID\": \"45545345343 \",\n                                          \t\"Rating\": \"1\"}\n\n                                       }\n}\n\nRESPONSE:\nHTTP/1.1 200 OK",
          "type": "json"
        }
      ]
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Recommender"
  }
] });
