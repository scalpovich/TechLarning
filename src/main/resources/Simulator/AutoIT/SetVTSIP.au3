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

    WinActivate("VTS Communications Handler (1)")
    WinMenuSelectItem("VTS Communications Handler (1)", "", "Tools", "Protocol &Options...")
	WinActivate("Communications Handler Settings", "General")
	ControlClick("VTS Communications Handler (1)", "", "[CLASS:Button; INSTANCE:4]"); pressing on checkbox "raw message and then perform a shift tab
	Send("+{TAB}") ; Presses Shift + Tab
	Send("{RIGHT}")
	WinActivate("VTS)")
    ControlClick("VTS", "", "[CLASS:Button; INSTANCE:1]") ; handling dialog to click Ok if it comes up
	Send("{ENTER}")

    WinActivate("Communications Handler Settings")
	ControlClick("Communications Handler Settings", "", "[CLASS:Button; INSTANCE:2]")  ; clickin on client radio button
    sleep(2000)
	ControlClick("Communications Handler Settings", "", "[CLASS:Edit; INSTANCE:10]"); pressing on checkbox "raw message and then perform a shift tab
	Send("{TAB}") ; clicked Host IP Address (clicked 1st section out of 4 section in Host IP) and then tab to navigate to Port
	Send("+{TAB}") ; Presses Shift + Tab to get to 1st postion of IP address in Host IP Address
	sleep(1000)
	Send("+{TAB}") ; Presses Shift + Tab to get to 1st postion of VTS address in VTS IP Address
    Send($CmdLine[1]) ; filling VTS IP Address
	Send("{TAB}")
	Send($CmdLine[2]) ; filling HOST IP Address
	Send("{TAB}")
	Send($CmdLine[3]) ; filling HOST Port
	sleep(2000)
	ControlClick("Communications Handler Settings", "", "[CLASS:Button; INSTANCE:15]") ; click Apply
	ControlClick("Communications Handler Settings", "", "[CLASS:Button; INSTANCE:13]") ; click OK