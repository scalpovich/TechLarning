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

   WinActive("Variables Manager")
   ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]")
   Sleep(1000)
   ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]")
   sleep(3000)
   WinWaitClose("Variables Manager")