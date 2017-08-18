#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("FINsim - Connect To Device") Then
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
 EndIf



