# JagSat-Onboard
Onboard systems utilized by the JagSat Floater Balloon deployed by Windham High School

# Control System Layout
	Java VM
			System Host Controller
					Executed upon startup, responsible for starting all controllers
				Subsystem Controller
					Avionics Subsystem	
						Ballast
						Parachute Disconnect
					Communications Subsystem
					Sensor Subsystem
		    (Handles the inputs from the Input Controller mainly...)
            
			IO Controller
				Input Controller
					Iridium Receiver
					Barometer / Altimeter
					Camera

				Output Controller
					Iridium Transmitter
					Camera

			System Controller
				System Dispatcher
					Responsible for executing commands requested by the scheduler
				System Scheduler
					Responsible for taking in command requests and executing them sequentially

