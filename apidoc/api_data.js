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
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>Word in the title of the App.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>Link of the App(In request it shoul be NULL).</p>"
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
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[\n    {\n        \"title\": \"Google Fit - Fitness Tracking\",\n        \"href\": \"/store/apps/details?id=com.google.android.apps.fitness\"\n    },\n    {\n        \"title\": \"Fitness Trainer FitProSport\",\n        \"href\": \"/store/apps/details?id=fitness.fitprosport\"\n    },\n    {\n        \"title\": \"Fitness Buddy : 300+ Exercises\",\n        \"href\": \"/store/apps/details?id=com.skyhealth.fitnessbuddyandroidfree\"\n    },\n    {\n        \"title\": \"Women's Home Fitness\",\n        \"href\": \"/store/apps/details?id=com.homefitness\"\n    },\n    {\n        \"title\": \"Home Fitness\",\n        \"href\": \"/store/apps/details?id=com.home.fitness\"\n    },\n    {\n        \"title\": \"Fitness & Bodybuilding\",\n        \"href\": \"/store/apps/details?id=softin.my.fast.fitness\"\n    },\n    {\n       \"title\": \"Total Fitness - Gym & Workouts\",\n        \"href\": \"/store/apps/details?id=com.bluecorner.totalgym\"\n    },\n    {\n        \"title\": \"Fitness Point\",\n        \"href\": \"/store/apps/details?id=com.std.fitness.point\"\n    },\n    {\n        \"title\": \"Runtastic Running & Fitness\",\n        \"href\": \"/store/apps/details?id=com.runtastic.android\"\n    },\n    {\n        \"title\": \"30 Day Fitness Challenges\",\n        \"href\": \"/store/apps/details?id=com.happydev.challenge\"\n    }\n]",
          "type": "json"
        }
      ]
    },
    "filename": "agile-recommender/apidoc.js",
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
    "filename": "agile-recommender/apidoc.js",
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
    "filename": "agile-recommender/apidoc.js",
    "groupTitle": "App"
  },
  {
    "description": "<p>AGILE Recommender Server API.</p>",
    "version": "0.0.1",
    "type": "",
    "url": "",
    "filename": "agile-recommender/apidoc.js",
    "group": "C__Users_spolater_git_agile_recommender_apidoc_js",
    "groupTitle": "C__Users_spolater_git_agile_recommender_apidoc_js",
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
    "filename": "agile-recommender/apidoc.js",
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
    "filename": "agile-recommender/apidoc.js",
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
    "filename": "agile-recommender/apidoc.js",
    "groupTitle": "Device"
  },
  {
    "type": "post",
    "url": "/Workflow/getCBWFRecomm",
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
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>Used in Response (In request it should be NULL).</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "datatag",
            "description": "<p>Words will be used in Content Based Filtering.</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "dataowner",
            "description": "<p>Used in Response (In request it should be NULL).</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "href",
            "description": "<p>Used in Response (In request it should be NULL).</p>"
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
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,soap,wsdl,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-soapserver\"\n    },\n   {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ibm,connections,profiles,status,update\",\n        \"dataowner\": \"\",\n        \"href\": \"/node/node-red-ibmconnections\"\n    },\n    {\n        \"type\": \"flow\",\n        \"datatag\": \"IoT,cloudant,nodered,IBM,bluemix\",\n        \"dataowner\": \"bsilverm\",\n        \"href\": \"/flow/7d4b5c1189c8f5df3a1f\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,tinkerpop,graphdb,gremlin,ibm\",\n        \"dataowner\": \"Sam Adams\",\n        \"href\": \"/node/node-red-contrib-tinkerpop\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ads-b,dump1090,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-ads-b\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"IBM,node-red,sensor,ble\",\n        \"dataowner\": \"Cristian Traistaru\",\n        \"href\": \"/node/node-red-contrib-sensortag\"\n    },\n    {\n        \"type\": \"flow\",\n        \"datatag\": \"SensorTag,TI,Bluemix,IoT,IBM,Simplelink\",\n        \"dataowner\": \"uwefassnacht\",\n        \"href\": \"/flow/0d458526303cfea9479d\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,couchdb,ibm\",\n        \"dataowner\": \"Neil Kolban\",\n        \"href\": \"/node/node-red-contrib-couchdb\"\n    },\n    {\n        \"type\": \"node\",\n        \"datatag\": \"node-red,ibm,flightaware\",\n        \"dataowner\": \"Rob Peeren\",\n        \"href\": \"/node/node-red-contrib-flightaware\"\n    },\n    {\n        \"type\": \"node\",\n       \"datatag\": \"node-red,bluemix,watson,iot,ibm\",\n        \"dataowner\": \"Nick O'Leary\",\n        \"href\": \"/node/node-red-contrib-ibm-watson-iot\"\n    }\n]",
          "type": "json"
        }
      ]
    },
    "filename": "agile-recommender/apidoc.js",
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
    "url": "/device/getIBCFWFRecomm",
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
    "filename": "agile-recommender/apidoc.js",
    "groupTitle": "Workflow"
  },
  {
    "type": "post",
    "url": "/device/getUBCFWFRecomm",
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
    "filename": "agile-recommender/apidoc.js",
    "groupTitle": "Workflow"
  }
] });
