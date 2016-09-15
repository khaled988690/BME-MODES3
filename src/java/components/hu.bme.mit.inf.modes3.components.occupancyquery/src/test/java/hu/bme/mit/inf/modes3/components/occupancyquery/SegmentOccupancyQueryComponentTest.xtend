package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.junit.Before
import org.junit.Test
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import java.util.HashMap
import java.util.ArrayList

public class SegmentOccupancyQueryComponentTest {
	var SectionOccupancyQueryComponent uut
	
	@Before
	def void before(){
		uut = new SectionOccupancyQueryComponent(CommunicationStackFactory::createLocalStack, new S88CommunicationReader(){
			override read() {
				newByteArrayOfSize(4) => [set(0, 0xAA as byte); set(1, 0xAA as byte); set(2, 0xAA as byte); set(3, 0xAA as byte);  ]
			}
		})
	}
	
	@Test
	def void segmentOccupancyQueryComponentTest(){
		val map = new HashMap<Integer, SegmentOccupancy>
		new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack) => [
			trackElementStateRegistry.segmentOccupancyChangeListener = new ISegmentOccupancyChangeListener(){
				override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
					map.put(id, newValue)
				}
			}
		]
		uut.process
		Thread.sleep(200)
		map.forEach[id, state | 
			println('''ID: «id» Occupancy «IF state == SegmentOccupancy.FREE» FREE «ELSE» OCCUPIED «ENDIF»''')
		]
		
		
	}
}