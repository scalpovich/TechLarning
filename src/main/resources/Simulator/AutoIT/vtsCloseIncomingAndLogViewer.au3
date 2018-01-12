#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------
   ; Script Start - Add your code below here
   #include <MsgBoxConstants.au3>
   #include <WinAPIFiles.au3>
   #include <Constants.au3>


   WinClose("Incoming Message")
   Sleep(2000)
   WinClose("LogViewer")
   Sleep(2000)
    WinClose("Visa Test System")
	sleep(1000)
	ControlClick("VTS", "", "[CLASS:Button; INSTANCE:2]")