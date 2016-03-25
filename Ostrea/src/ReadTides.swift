// http://tidesandcurrents.noaa.gov/api/datagetter?begin_date=20160101&end_date=20160101&station=8454000&product=water_level&datum=mllw&units=metric&time_zone=gmt&application=web_services&format=xml

import Foundation

let requestURL = NSURL(string: "http://tidesandcurrents.noaa.gov/api/datagetter?begin_date=20160101&end_date=20160101&station=8454000&product=water_level&datum=mllw&units=metric&time_zone=gmt&application=web_services&format=xml")!

let urlRequest: NSMutableURLRequest = NSMutableURLRequest(URL: requestURL)

let session = NSURLSession.sharedSession()

let task = session.dataTaskWithRequest(urlRequest) {
    (data, response, error) -> Void in
    
	print("in task")
        let httpResponse = response as! NSHTTPURLResponse
        let statusCode = httpResponse.statusCode


  
        if (statusCode == 200) {
            print("Everyone is fine, file downloaded successfully.")
        } else {
	    print("Error %@",statusCode)
}
}

print("Running task")
task.resume()

print("after running task")