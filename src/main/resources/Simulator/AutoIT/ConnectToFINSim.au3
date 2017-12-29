#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here

	WinActivate("FINsim - Connect To Server", "Server Name:")
    ControlSetText("FINsim - Connect To Server","","[CLASS:Edit; INSTANCE:1]", "")
    ControlSetText("FINsim - Connect To Server","","[CLASS:Edit; INSTANCE:2]", $CmdLine[1])
	Sleep(1000)
	ControlSetText("FINsim - Connect To Server","","[CLASS:Edit; INSTANCE:4]", $CmdLine[2])
	Sleep(1000)
	ControlClick("FINsim - Connect To Server","","[CLASS:Button; INSTANCE:1]")