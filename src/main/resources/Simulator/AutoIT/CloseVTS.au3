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

 If(WinExists("VTS")) Then
	    WinActivate("VTS")
	  If ControlCommand ("VTS", "", "[CLASS:Button; INSTANCE:2]", "IsVisible") Then
		 ControlClick("VTS","","[CLASS:Button; INSTANCE:2]") ; to handle OK dialog that may sometimes come up
		 Sleep(5000)
	  EndIf
   EndIf

if(WinExists("Visa Test System")) Then
   WinActivate("Visa Test System")
   WinMenuSelectItem("Visa Test System", "", "&Tools", "&Start Communications...")
   WinActivate("VTS Communications Handler")
   Local $sText = ControlGetText ("VTS Communications Handler", "", "[CLASS:Static; INSTANCE:14]")
   if ($sText="UP") Then
	  WinMenuSelectItem("VTS Communications Handler", "", "&Line", "Stop &Line")
   EndIf

   Sleep(5000)
EndIf

 If(WinExists("Visa Test System")) Then
	  WinActivate("Visa Test System")
	  WinMenuSelectItem("Visa Test System", "", "&File", "E&xit")
	  Sleep(5000)
   EndIf

if(WinExists("Microsoft Visual C++ Debug Library")) Then
    WinActivate("Microsoft Visual C++ Debug Library")
	 ControlClick("Microsoft Visual C++ Debug Library","","[CLASS:Button; INSTANCE:1]")
EndIf

    If(WinExists("VTS")) Then
	    WinActivate("VTS")
	  If ControlCommand ("VTS", "", "[CLASS:Button; INSTANCE:2]", "IsVisible") Then
		 ControlClick("VTS","","[CLASS:Button; INSTANCE:2]") ; to handle OK dialog that may sometimes come up
		 Sleep(5000)
	  EndIf
   EndIf

if(WinExists("Microsoft Visual C++ Debug Library")) Then
    WinActivate("Microsoft Visual C++ Debug Library")
	 ControlClick("Microsoft Visual C++ Debug Library","","[CLASS:Button; INSTANCE:1]")
EndIf



