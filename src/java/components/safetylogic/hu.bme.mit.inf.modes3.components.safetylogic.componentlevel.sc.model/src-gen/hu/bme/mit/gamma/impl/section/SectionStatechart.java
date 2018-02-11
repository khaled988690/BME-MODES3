package hu.bme.mit.gamma.impl.section;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;
import org.yakindu.scr.section.ISectionStatemachine.SCIProtocolRequiredCWListener;
import org.yakindu.scr.section.ISectionStatemachine.SCIControlProvidedListener;
import org.yakindu.scr.section.ISectionStatemachine.SCIProtocolRequiredCCWListener;
import org.yakindu.scr.section.SectionStatemachine;
import org.yakindu.scr.section.SectionStatemachine.State;

public class SectionStatechart implements SectionStatechartInterface {
	// The wrapped Yakindu statemachine
	private SectionStatemachine sectionStatemachine = new SectionStatemachine();
	// Port instances
	private ProtocolProvidedCCW protocolProvidedCCW = new ProtocolProvidedCCW();
	private ProtocolRequiredCW protocolRequiredCW = new ProtocolRequiredCW();
	private ControlProvided controlProvided = new ControlProvided();
	private TrainRequired trainRequired = new TrainRequired();
	private ProtocolRequiredCCW protocolRequiredCCW = new ProtocolRequiredCCW();
	private ProtocolProvidedCW protocolProvidedCW = new ProtocolProvidedCW();
	// Indicates which queues are active in this cycle
	private boolean insertQueue = true;
	private boolean processQueue = false;
	// Event queues for the synchronization of statecharts
	private Queue<Event> eventQueue1 = new LinkedList<Event>();
	private Queue<Event> eventQueue2 = new LinkedList<Event>();
	
	public SectionStatechart() {
		// Initializing and entering the wrapped statemachine
		sectionStatemachine.init();
		sectionStatemachine.enter();
	}
	
	/** Enters the statemachine. Should be used only be the container (composite system) class. */
	public void enter() {
		sectionStatemachine.enter();
	}
	
	/** Changes the event queues of the component instance. Should be used only be the container (composite system) class. */
	public void changeEventQueues() {
		insertQueue = !insertQueue;
		processQueue = !processQueue;
	}
	
	/** Changes the event queues to which the events are put. Should be used only be a cascade container (composite system) class. */
	public void changeInsertQueue() {
	    insertQueue = !insertQueue;
	}
	
	/** Returns whether the eventQueue containing incoming messages is empty. Should be used only be the container (composite system) class. */
	public boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}
	
	/** Returns the event queue into which events should be put in the particular cycle. */
	private Queue<Event> getInsertQueue() {
		if (insertQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	/** Returns the event queue from which events should be inspected in the particular cycle. */
	private Queue<Event> getProcessQueue() {
		if (processQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	/** Changes event queues and initiating a cycle run. */
	@Override
	public void runCycle() {
		changeEventQueues();
		runComponent();
	}
	
	/** Changes the insert queue and initiates a run. */
	public void runAndRechangeInsertQueue() {
		// First the insert queue is changed back, so self-event sending can work
	    changeInsertQueue();
	    runComponent();
	}
	
	/** Initiates a cycle run without changing the event queues. It is needed if this component is contained (wrapped) by another component.
	Should be used only be the container (composite system) class. */
	public void runComponent() {
		Queue<Event> eventQueue = getProcessQueue();
		while (!eventQueue.isEmpty()) {
				Event event = eventQueue.remove();
				switch (event.getEvent()) {
					case "ProtocolProvidedCCW.Release": 
						sectionStatemachine.getSCIProtocolProvidedCCW().raiseRelease();
					break;
					case "ProtocolProvidedCCW.Reserve": 
						sectionStatemachine.getSCIProtocolProvidedCCW().raiseReserve();
					break;
					case "ProtocolProvidedCCW.CanGo": 
						sectionStatemachine.getSCIProtocolProvidedCCW().raiseCanGo();
					break;
					case "ProtocolProvidedCCW.CannotGo": 
						sectionStatemachine.getSCIProtocolProvidedCCW().raiseCannotGo();
					break;
					case "ControlProvided.RestartProtocol": 
						sectionStatemachine.getSCIControlProvided().raiseRestartProtocol();
					break;
					case "TrainRequired.Occupy": 
						sectionStatemachine.getSCITrainRequired().raiseOccupy();
					break;
					case "TrainRequired.Unoccupy": 
						sectionStatemachine.getSCITrainRequired().raiseUnoccupy();
					break;
					case "ProtocolProvidedCW.Release": 
						sectionStatemachine.getSCIProtocolProvidedCW().raiseRelease();
					break;
					case "ProtocolProvidedCW.Reserve": 
						sectionStatemachine.getSCIProtocolProvidedCW().raiseReserve();
					break;
					case "ProtocolProvidedCW.CanGo": 
						sectionStatemachine.getSCIProtocolProvidedCW().raiseCanGo();
					break;
					case "ProtocolProvidedCW.CannotGo": 
						sectionStatemachine.getSCIProtocolProvidedCW().raiseCannotGo();
					break;
					default:
						throw new IllegalArgumentException("No such event!");
				}
		}
		sectionStatemachine.runCycle();
	}    		
	
	// Inner classes representing Ports
	public class ProtocolProvidedCCW implements ProtocolInterface.Provided {
		private List<ProtocolInterface.Listener.Provided> registeredListeners = new LinkedList<ProtocolInterface.Listener.Provided>();

		@Override
		public void raiseRelease() {
			getInsertQueue().add(new Event("ProtocolProvidedCCW.Release", null));
		}
		
		@Override
		public void raiseReserve() {
			getInsertQueue().add(new Event("ProtocolProvidedCCW.Reserve", null));
		}
		
		@Override
		public void raiseCanGo() {
			getInsertQueue().add(new Event("ProtocolProvidedCCW.CanGo", null));
		}
		
		@Override
		public void raiseCannotGo() {
			getInsertQueue().add(new Event("ProtocolProvidedCCW.CannotGo", null));
		}

		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolProvidedCCW getProtocolProvidedCCW() {
		return protocolProvidedCCW;
	}
	
	public class ProtocolRequiredCW implements ProtocolInterface.Required {
		private List<ProtocolInterface.Listener.Required> registeredListeners = new LinkedList<ProtocolInterface.Listener.Required>();


		@Override
		public boolean isRaisedRelease() {
			return sectionStatemachine.getSCIProtocolRequiredCW().isRaisedRelease();
		}
		@Override
		public boolean isRaisedReserve() {
			return sectionStatemachine.getSCIProtocolRequiredCW().isRaisedReserve();
		}
		@Override
		public boolean isRaisedCanGo() {
			return sectionStatemachine.getSCIProtocolRequiredCW().isRaisedCanGo();
		}
		@Override
		public boolean isRaisedCannotGo() {
			return sectionStatemachine.getSCIProtocolRequiredCW().isRaisedCannotGo();
		}
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			registeredListeners.add(listener);
			//sectionStatemachine.getSCIProtocolRequiredCW().getListeners().clear();
			sectionStatemachine.getSCIProtocolRequiredCW().getListeners().add(new SCIProtocolRequiredCWListener() {
				@Override
				public void onReleaseRaised() {
					listener.raiseRelease();
				}
				
				@Override
				public void onReserveRaised() {
					listener.raiseReserve();
				}
				
				@Override
				public void onCanGoRaised() {
					listener.raiseCanGo();
				}
				
				@Override
				public void onCannotGoRaised() {
					listener.raiseCannotGo();
				}
			});
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolRequiredCW getProtocolRequiredCW() {
		return protocolRequiredCW;
	}
	
	public class ControlProvided implements ControlInterface.Provided {
		private List<ControlInterface.Listener.Provided> registeredListeners = new LinkedList<ControlInterface.Listener.Provided>();

		@Override
		public void raiseRestartProtocol() {
			getInsertQueue().add(new Event("ControlProvided.RestartProtocol", null));
		}

		@Override
		public boolean isRaisedDisableSection() {
			return sectionStatemachine.getSCIControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return sectionStatemachine.getSCIControlProvided().getDisableSectionValue();
		}
		@Override
		public boolean isRaisedEnableSection() {
			return sectionStatemachine.getSCIControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return sectionStatemachine.getSCIControlProvided().getEnableSectionValue();
		}
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
			//sectionStatemachine.getSCIControlProvided().getListeners().clear();
			sectionStatemachine.getSCIControlProvided().getListeners().add(new SCIControlProvidedListener() {
				@Override
				public void onDisableSectionRaised(long value) {
					listener.raiseDisableSection(value);
				}
				
				@Override
				public void onEnableSectionRaised(long value) {
					listener.raiseEnableSection(value);
				}
			});
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ControlProvided getControlProvided() {
		return controlProvided;
	}
	
	public class TrainRequired implements TrainInterface.Required {
		private List<TrainInterface.Listener.Required> registeredListeners = new LinkedList<TrainInterface.Listener.Required>();

		@Override
		public void raiseOccupy() {
			getInsertQueue().add(new Event("TrainRequired.Occupy", null));
		}
		
		@Override
		public void raiseUnoccupy() {
			getInsertQueue().add(new Event("TrainRequired.Unoccupy", null));
		}

		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public TrainRequired getTrainRequired() {
		return trainRequired;
	}
	
	public class ProtocolRequiredCCW implements ProtocolInterface.Required {
		private List<ProtocolInterface.Listener.Required> registeredListeners = new LinkedList<ProtocolInterface.Listener.Required>();


		@Override
		public boolean isRaisedRelease() {
			return sectionStatemachine.getSCIProtocolRequiredCCW().isRaisedRelease();
		}
		@Override
		public boolean isRaisedReserve() {
			return sectionStatemachine.getSCIProtocolRequiredCCW().isRaisedReserve();
		}
		@Override
		public boolean isRaisedCanGo() {
			return sectionStatemachine.getSCIProtocolRequiredCCW().isRaisedCanGo();
		}
		@Override
		public boolean isRaisedCannotGo() {
			return sectionStatemachine.getSCIProtocolRequiredCCW().isRaisedCannotGo();
		}
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			registeredListeners.add(listener);
			//sectionStatemachine.getSCIProtocolRequiredCCW().getListeners().clear();
			sectionStatemachine.getSCIProtocolRequiredCCW().getListeners().add(new SCIProtocolRequiredCCWListener() {
				@Override
				public void onReleaseRaised() {
					listener.raiseRelease();
				}
				
				@Override
				public void onReserveRaised() {
					listener.raiseReserve();
				}
				
				@Override
				public void onCanGoRaised() {
					listener.raiseCanGo();
				}
				
				@Override
				public void onCannotGoRaised() {
					listener.raiseCannotGo();
				}
			});
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolRequiredCCW getProtocolRequiredCCW() {
		return protocolRequiredCCW;
	}
	
	public class ProtocolProvidedCW implements ProtocolInterface.Provided {
		private List<ProtocolInterface.Listener.Provided> registeredListeners = new LinkedList<ProtocolInterface.Listener.Provided>();

		@Override
		public void raiseRelease() {
			getInsertQueue().add(new Event("ProtocolProvidedCW.Release", null));
		}
		
		@Override
		public void raiseReserve() {
			getInsertQueue().add(new Event("ProtocolProvidedCW.Reserve", null));
		}
		
		@Override
		public void raiseCanGo() {
			getInsertQueue().add(new Event("ProtocolProvidedCW.CanGo", null));
		}
		
		@Override
		public void raiseCannotGo() {
			getInsertQueue().add(new Event("ProtocolProvidedCW.CannotGo", null));
		}

		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolProvidedCW getProtocolProvidedCW() {
		return protocolProvidedCW;
	}
	
	/** Checks whether the wrapped statemachine is in the given state. */
	public boolean isStateActive(State state) {
		return sectionStatemachine.isStateActive(state);
	}
	
	
}