define({
  "name": "Recommender",
  "version": "0.0.0",
  "description": "",
  "id": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
  "timestamp": 1464527788688,
  "requests": [
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "7ffd2e2e-3e24-0fa7-ad7b-2fe995406adf",
      "name": "Get Profile",
      "description": "",
      "url": "http://54.213.147.198:8080/agileRecommender/getProfile",
      "method": "GET",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n  \t\"userID\": 3,  \n    \"devices\":null,\n  \t\"apps\":null,\n  \t\"wfs\":null ,\n    \"resources\":null\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1468584216881
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "9edb4894-eb47-c81c-2bbd-c1f39db0f3a5",
      "name": "UBCF App Recomm",
      "description": "",
      "url": "http://54.213.147.198:8080/agileRecommender/app/UBCFAppRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n \t\"userID\":2,\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n    \"resources\":\"\"\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "responses": [],
      "version": 2
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "a6b1f1e9-93bb-6076-3fc5-15042cc9ecc9",
      "name": "CB App Recommendation",
      "description": "",
      "url": "http://54.213.147.198:8080/agileRecommender/app/getCBAppRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n \t\"userID\":\"\",\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n    \"resources\":\"\"\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1468583827561
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "d0ad9183-57d8-e618-b401-8d7cc5fd3552",
      "name": "UBCF Wf Recomm",
      "description": "",
      "url": "http://54.213.147.198:8080/agileRecommender/workflow/getUBCFWfRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n \t\"userID\":2,\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n    \"resources\":\"\"\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1468584091122
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "f678017c-ba18-8e9e-1b64-b0678d565156",
      "name": "CB WF Recommendation",
      "description": "",
      "url": "http://54.213.147.198:8080/agileRecommender/workflow/getCBWFRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n \t\"userID\":\"\",\t\n  \t\"devices\":\"temperature\",\n  \t\"apps\":\"\",\n  \t\"wfs\":\"\" ,\n    \"resources\":\"\"\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1468583902666
    }
  ],
  "sampleUrl": false,
  "apidoc": "0.2.0",
  "generator": {
    "name": "apidoc",
    "time": "2016-07-15T12:27:11.786Z",
    "url": "http://apidocjs.com",
    "version": "0.16.1"
  }
});
