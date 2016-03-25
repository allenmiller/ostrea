/**
 * 
 */
package net.ajmiller.Ostrea;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author ajmiller
 *
 */
public class Ostrea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting main()");
		TidePredictions td = new TidePredictions("20160324", "72","9445133");
		System.out.println(td);
//		System.out.println(tdjson.names());
		//System.out.println(tdjson.keys());
		
//		Iterator<String> i = tdjson.keys();
//		while (i.hasNext()) {
			//System.out.println(i.next());
//		}

//		JSONObject  metadataPoints = (JSONObject) tdjson.get("metadata");
//		Iterator<Object> ii = dataPoints.iterator();
//		System.out.println(metadataPoints);
//		Iterator<Object> ji = metadataPoints.iterator();
//		while (ji.hasNext()){
//			System.out.println((JSONObject)ji.next());
//		}

		System.out.println(new Stations());

	}

}
