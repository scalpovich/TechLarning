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

   WinWaitActive("Variables Manager")
   Sleep(10000)

   If ControlCommand ("Variables Manager", "", "[CLASS:Button; INSTANCE:1]", "IsVisible") Then
	  ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]") ; to handle OK dialog that may sometimes come up
	  Sleep(1000)
   EndIf
   If ControlCommand ("Variables Manager", "", "[CLASS:Button; INSTANCE:1]", "IsVisible") Then
	  ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]") ; to handle OK dialog that may sometimes come up
	  sleep(3000)
	EndIf
   WinMenuSelectItem("Variables Manager", "", "&File", "E&xit")