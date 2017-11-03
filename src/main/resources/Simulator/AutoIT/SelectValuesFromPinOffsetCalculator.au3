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

    WinActivate("FINsim - Connect To Device", "Please Select Device To Connect To")
	ControlClick("FINsim - Connect To Device", "", "Select")
	Sleep(5000)

    WinActivate("[CLASS:FINsim. The EFT Simulator]", "Card To Use For Transactions")
	Send ("!T")
    Send ("o")
    WinMenuSelectItem("[CLASS:FINsim. The EFT Simulator]", "", "&Tools", "Pin &Offset Calculator")


    WinWait("PIN Offset Calculator", "", 100)
    WinActivate("PIN Offset Calculator", "Card Number :")
	ControlClick("PIN Offset Calculator", "", "[CLASS:Edit; INSTANCE:1]")

	Sleep(5000)


	WinActivate("PIN Offset Calculator", "Card Number :")

    ControlSetText("PIN Offset Calculator","","Edit1", $CmdLine[1])
	ControlSetText("PIN Offset Calculator","","Edit2", $CmdLine[2])
	ControlSetText("PIN Offset Calculator","","Edit3", $CmdLine[3])

	ControlCommand("PIN Offset Calculator", "", "[CLASS:ComboBox; INSTANCE:1]", "SelectString", $CmdLine[4])
	ControlCommand("PIN Offset Calculator", "", "[CLASS:ComboBox; INSTANCE:2]", "SelectString", $CmdLine[5])
	ControlCommand("PIN Offset Calculator", "", "[CLASS:ComboBox; INSTANCE:3]", "SelectString", $CmdLine[6])
	ControlSetText("PIN Offset Calculator","","Edit4", $CmdLine[7])
	ControlCommand("PIN Offset Calculator", "", "[CLASS:ComboBox; INSTANCE:4]", "SelectString", $CmdLine[8])

   Sleep(3000)