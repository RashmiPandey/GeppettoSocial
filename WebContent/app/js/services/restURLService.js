/**
 * @author Rashmi
 * @date Jan'04 2016
 * 
 */


app.service("RestURL", [ '$log', '$location', function($log, $location) {
	$log.debug("App base URL: ", $location.absUrl().split("/#")[0]);

	var self = this;
	self.baseURL = $location.absUrl().split("/#")[0];

} ]);