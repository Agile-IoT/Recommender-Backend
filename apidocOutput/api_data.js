define({ "api": [
  {
    "type": "post",
    "url": "/app/getCBAppRecomm",
    "title": "Content Based Filtering",
    "version": "0.0.1",
    "name": "getCBAppRecomm",
    "group": "App",
    "description": "<p>Returns App Recommendation Results based on Content Based Filtering</p>",
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
    "groupTitle": "App",
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
    "url": "/app/getIBCFAppRecomm",
    "title": "Item Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getIBCFAppRecomm",
    "group": "App",
    "description": "<p>Returns App Recommendation Results based on IBCF. Not implemented yet.</p>",
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
      }
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "App"
  },
  {
    "type": "post",
    "url": "/app/getUBCFAppRecomm",
    "title": "User Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getUBCFAppRecomm",
    "group": "App",
    "description": "<p>Returns App Recommendation Results based on UBCF. Not implemented yet.</p>",
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
      }
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "App"
  },
  {
    "description": "<p>AGILE Recommender Server API.</p>",
    "version": "0.0.1",
    "type": "",
    "url": "",
    "filename": "apidocInput/apidoc.js",
    "group": "C__Users_spolater_git_agile_recommender_apidocInput_apidoc_js",
    "groupTitle": "C__Users_spolater_git_agile_recommender_apidocInput_apidoc_js",
    "name": ""
  },
  {
    "type": "post",
    "url": "/device/getCBDevRecomm",
    "title": "Content Based Filtering",
    "version": "0.0.1",
    "name": "getCBDevRecomm",
    "group": "Device",
    "description": "<p>Returns Device Recommendation Results based on Content Based Filtering. Not implemented yet.</p>",
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Device"
  },
  {
    "type": "post",
    "url": "/device/getIBCFDevRecomm",
    "title": "Item Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getIBCFDevRecomm",
    "group": "Device",
    "description": "<p>Returns Device Recommendation Results based on IBCF. Not implemented yet.</p>",
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Device"
  },
  {
    "type": "post",
    "url": "/device/getUBCFDevRecomm",
    "title": "User Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getUBCFDevRecomm",
    "group": "Device",
    "description": "<p>Returns Device Recommendation Results based on UBCF. Not implemented yet.</p>",
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Device"
  },
  {
    "type": "post",
    "url": "/workflow/getCBWFRecomm",
    "title": "Content Based Filtering",
    "version": "0.0.1",
    "name": "getCBWFRecomm",
    "group": "Workflow",
    "description": "<p>Returns Workflow Recommendation Results based on Content Based Filtering</p>",
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
    "groupTitle": "Workflow",
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
    "url": "/workflow/getIBCFWFRecomm",
    "title": "Item Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getIBCFWFRecomm",
    "group": "Workflow",
    "description": "<p>Returns Workflow Recommendation Results based on IBCF. Not implemented yet.</p>",
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
      }
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Workflow"
  },
  {
    "type": "post",
    "url": "/workflow/getUBCFWFRecomm",
    "title": "User Based Collaborative Filtering",
    "version": "0.0.1",
    "name": "getUBCFWFRecomm",
    "group": "Workflow",
    "description": "<p>Returns Workflow Recommendation Results based on UBCF. Not implemented yet.</p>",
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
      }
    },
    "filename": "apidocInput/apidoc.js",
    "groupTitle": "Workflow"
  }
] });
