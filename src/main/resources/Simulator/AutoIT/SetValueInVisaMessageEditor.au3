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
    ControlCommand("Field Editor", '', "ComboBox2", "SelectString", 'Literal')
	Sleep(3000)
	If ControlCommand("Field Editor", '', "ComboBox1", "IsVisible", "") Then
		ControlCommand("Field Editor", '', "ComboBox1", "SelectString", $CmdLine[1])
	Else
		ControlSetText("Field Editor", '', "Edit3", $CmdLine[1])
	EndIf
	Sleep(3000)
	ControlClick("Field Editor", '', "[CLASS:Button; INSTANCE:11]")

	WinActivate("VTS", "&Yes")
	ControlClick("Field Editor", '', "&Yes")

    ControlClick("Message Editor", "", "[CLASS:Button; INSTANCE:5]")