//package com.jungam.manage.util;
//
//import static java.util.HashMap.MAXIMUM_CAPACITY;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.jungam.manage.vo.BoardVO;
//
//@SuppressWarnings("rawtypes")
//public class BoardHashMap<K, V> extends HashMap {
//	private static final long serialVersionUID = -5660390430058374739L; // I don't know
//	private final static Logger logger = Logger.getLogger(BoardHashMap.class);
//	
//	public void putAll(HashMap<? extends Integer,? extends BoardVO> m) {
//		int numKeysToBeAdded = m.size();
//			 if (numKeysToBeAdded == 0)
//			     return;
//			
//			 /*
//			  * Expand the map if the map if the number of mappings to be added
//			  * is greater than or equal to threshold.  This is conservative; the
//			  * obvious condition is (m.size() + size) >= threshold, but this
//			  * condition could result in a map with twice the appropriate capacity,
//			  * if the keys to be added overlap with the keys already in this map.
//			  * By using the conservative calculation, we subject ourself
//			  * to at most one extra resize.
//			  */
//			 if (numKeysToBeAdded > threshold) {
//			     int targetCapacity = (int)(numKeysToBeAdded / loadFactor + 1);
//			     if (targetCapacity > MAXIMUM_CAPACITY)
//			         targetCapacity = MAXIMUM_CAPACITY;
//			     int newCapacity = table.length;
//			     while (newCapacity < targetCapacity)
//			         newCapacity <<= 1;
//			     if (newCapacity > table.length)
//			         resize(newCapacity);
//			 }
//			
//			 for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {
//			     Map.Entry<? extends K, ? extends V> e = i.next();
//			     put(e.getKey(), e.getValue());
//			 }
//  
//	}
//}
