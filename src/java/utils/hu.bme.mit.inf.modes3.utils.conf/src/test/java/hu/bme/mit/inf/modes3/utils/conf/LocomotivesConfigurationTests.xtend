package hu.bme.mit.inf.modes3.utils.conf

import org.junit.Assert
import org.junit.Test

class LocomotivesConfigurationTests {

	@Test def void locomotiveNamesTest() {
		val referenceNames = #{"br294", "sncf", "taurus"}
		val loadedNames = LocomotivesConfiguration.INSTANCE.locomotiveNames
		Assert.assertEquals(referenceNames, loadedNames)
	}

	@Test def void locomotiveIdsTest() {
		val referenceIds = #{8, 9, 10}
		val loadedIds = LocomotivesConfiguration.INSTANCE.locomotiveIds
		Assert.assertEquals(referenceIds, loadedIds)
	}

	@Test def void mappingsTest() {
		val referenceMapping = #{"br294" -> 8, "taurus" -> 9, "sncf" -> 10}
		val loadedMapping = LocomotivesConfiguration.INSTANCE.locomotivesWithNameAndId
		Assert.assertEquals(referenceMapping, loadedMapping)
	}

	@Test def void mappingTest() {
		val referenceName = "Taurus"
		val referenceId = 9
		val loadedId = LocomotivesConfiguration.INSTANCE.getLocomotiveIdByName(referenceName)
		Assert.assertEquals(referenceId, loadedId)
	}
}
