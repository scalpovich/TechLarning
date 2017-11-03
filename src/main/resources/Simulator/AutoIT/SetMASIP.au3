#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
	WinActivate("MasterCard Authorization Simulator <MAS16.Q4>", "Test Options")
	ControlClick("MasterCard Authorization Simulator <MAS16.Q4>", "", "[NAME:optserverclient_11]")
	Send("{TAB}")
	Sleep(300)
	Send("^a")
	Send($CmdLine[1])
	Sleep(300)
	Send("{TAB}")
	Sleep(300)
	Send($CmdLine[2])
	Sleep(300)
	Send($CmdLine[3])
	Sleep(300)
	Send($CmdLine[4])
	Sleep(300)
	Send($CmdLine[5])

	ControlClick("MasterCard Authorization Simulator <MAS16.Q4>", "", "[NAME:cmdSave_1]")