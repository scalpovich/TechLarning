#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
Opt("WinWaitDelay", 500) ;250 milliseconds

If WinExists($CmdLine[1]) Then
   WinActivate($CmdLine[1], "Test Mode")
	ControlClick($CmdLine[1],"","[NAME:comboBox1]")
	Sleep(1000)
	Send("{DOWN}")
	Sleep(1000)
	Send("{ENTER}")
	Sleep(10000)
EndIf
