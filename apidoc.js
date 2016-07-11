/**
 * @apiDescription AGILE Recommender Server API.
 * @apiVersion 0.0.1
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
 * @api {post} /app/getCBAppRecomm Content Based Filtering
 * @apiVersion 0.0.1
 * @apiName getCBAppRecomm
 * @apiGroup App
 * @apiDescription Returns App Recommendation Results based on Content Based Filtering
 *
 * @apiParam {String} title  	   Word in the title of the App.
 * @apiParam {String} href	   Link of the App(In request it shoul be NULL).
 *
 * @apiSuccess {String} title      Title of the recomended App.
 * @apiSuccess {String} href	   Link of sthe App.
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * [
 *     {
 *         "title": "Google Fit - Fitness Tracking",
 *         "href": "/store/apps/details?id=com.google.android.apps.fitness"
 *     },
 *     {
 *         "title": "Fitness Trainer FitProSport",
 *         "href": "/store/apps/details?id=fitness.fitprosport"
 *     },
 *     {
 *         "title": "Fitness Buddy : 300+ Exercises",
 *         "href": "/store/apps/details?id=com.skyhealth.fitnessbuddyandroidfree"
 *     },
 *     {
 *         "title": "Women's Home Fitness",
 *         "href": "/store/apps/details?id=com.homefitness"
 *     },
 *     {
 *         "title": "Home Fitness",
 *         "href": "/store/apps/details?id=com.home.fitness"
 *     },
 *     {
 *         "title": "Fitness & Bodybuilding",
 *         "href": "/store/apps/details?id=softin.my.fast.fitness"
 *     },
 *     {
 *        "title": "Total Fitness - Gym & Workouts",
 *         "href": "/store/apps/details?id=com.bluecorner.totalgym"
 *     },
 *     {
 *         "title": "Fitness Point",
 *         "href": "/store/apps/details?id=com.std.fitness.point"
 *     },
 *     {
 *         "title": "Runtastic Running & Fitness",
 *         "href": "/store/apps/details?id=com.runtastic.android"
 *     },
 *     {
 *         "title": "30 Day Fitness Challenges",
 *         "href": "/store/apps/details?id=com.happydev.challenge"
 *     }
 * ]
 * @apiUse NoRecommendationFound
 */

/**
 * @api {post} /app/getUBCFAppRecomm User Based Collaborative Filtering 
 * @apiVersion 0.0.1
 * @apiName getUBCFAppRecomm
 * @apiGroup App
 * @apiDescription Returns App Recommendation Results based on UBCF.
 * Not implemented yet.
 *
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 *
 * @apiSuccess {String} title      Title of the recomended App.
 * @apiSuccess {String} href	   Link of sthe App.
 */


/**
 * @api {post} /app/getIBCFAppRecomm Item Based Collaborative Filtering
 * @apiVersion 0.0.1
 * @apiName getIBCFAppRecomm
 * @apiGroup App
 * @apiDescription Returns App Recommendation Results based on IBCF.
 * Not implemented yet.
 *
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 *
 * @apiSuccess {String} title      	Title of the recomended App.
 * @apiSuccess {String} href	   	Link of sthe App.
 */

/**
 * @api {post} /Workflow/getCBWFRecomm Content Based Filtering
 * @apiVersion 0.0.1
 * @apiName getCBWFRecomm
 * @apiGroup Workflow
 * @apiDescription Returns Workflow Recommendation Results based on Content Based Filtering
 *
 * @apiParam {String} type	   Used in Response (In request it should be NULL).
 * @apiParam {String} datatag	   Words will be used in Content Based Filtering.
 * @apiParam {String} dataowner	   Used in Response (In request it should be NULL).
 * @apiParam {String} href	   Used in Response (In request it should be NULL).
 * @apiSuccess {String} type	   node or workflow.
 * @apiSuccess {String} datatag	   tags of node or workflow.
 * @apiSuccess {String} dataowner  developer's name.
 * @apiSuccess {String} href	   link of the node or workflow.
 *
 * @apiSuccessExample Success-Response:
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
 * @api {post} /device/getUBCFWFRecomm User Based Collaborative Filtering 
 * @apiVersion 0.0.1
 * @apiName getUBCFWFRecomm
 * @apiGroup Workflow
 * @apiDescription Returns Workflow Recommendation Results based on UBCF.
 * Not implemented yet.
 * 
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 *
 * @apiSuccess {String} type	   node or workflow.
 * @apiSuccess {String} datatag	   tags of node or workflow.
 * @apiSuccess {String} dataowner  developer's name.
 * @apiSuccess {String} href	   link of the node or workflow.
 */



/**
 * @api {post} /device/getIBCFWFRecomm Item Based Collaborative Filtering
 * @apiVersion 0.0.1
 * @apiName getIBCFWFRecomm
 * @apiGroup Workflow
 * @apiDescription Returns Workflow Recommendation Results based on IBCF.
 * Not implemented yet.
 *
 *
 * @apiParam {String} installedApps	installed apps on the gateway.
 * @apiParam {String} pluggedDevs	plugged devices on the gateway.
 * @apiParam {String} installedWFs	installed nodes on the gateway.
 * @apiParam {String} resources		remaining resources of the gateway.
 *
 * @apiSuccess {String} type	   node or workflow.
 * @apiSuccess {String} datatag	   tags of node or workflow.
 * @apiSuccess {String} dataowner  developer's name.
 * @apiSuccess {String} href	   link of the node or workflow.
 */


/**
 * @api {post} /device/getCBDevRecomm Content Based Filtering 
 * @apiVersion 0.0.1
 * @apiName getCBDevRecomm
 * @apiGroup Device 
 * @apiDescription Returns Device Recommendation Results based on Content Based Filtering.
 * Not implemented yet.
 *
 */


/**
 * @api {post} /device/getUBCFDevRecomm User Based Collaborative Filtering 
 * @apiVersion 0.0.1
 * @apiName getUBCFDevRecomm
 * @apiGroup Device 
 * @apiDescription Returns Device Recommendation Results based on UBCF.
 * Not implemented yet.
 *
 */


/**
 * @api {post} /device/getIBCFDevRecomm Item Based Collaborative Filtering
 * @apiVersion 0.0.1
 * @apiName getIBCFDevRecomm
 * @apiGroup Device 
 * @apiDescription Returns Device Recommendation Results based on IBCF.
 * Not implemented yet.
 *
 */
