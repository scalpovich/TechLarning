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

   	WinActivate("Message Editor")
    ControlClick("Message Editor", "", "&Field Editor ...");

	WinActivate("Field Editor")
    ControlCommand("Field Editor", '', "[CLASS:ComboBox; INSTANCE:2]", "SetCurrentSelection", "Literal")
	Sleep(5000)
	ControlSetText("Field Editor", '', "[CLASS:Edit; INSTANCE:3]", $CmdLine[1])
	Sleep(5000)
	ControlClick("Field Editor", '', "[CLASS:Button; INSTANCE:11]")

	WinActivate("VTS", "&Yes")
	ControlClick("Field Editor", '', "&Yes")

    ControlClick("Message Editor", "", "[CLASS:Button; INSTANCE:5]")