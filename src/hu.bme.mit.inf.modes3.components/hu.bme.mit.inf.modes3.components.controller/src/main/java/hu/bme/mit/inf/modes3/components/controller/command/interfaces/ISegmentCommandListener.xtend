package hu.bme.mit.inf.modes3.components.controller.command.interfaces

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

interface ISegmentCommandListener {
	def void onSegmentCommand(int id, SegmentStateValue state) 
}