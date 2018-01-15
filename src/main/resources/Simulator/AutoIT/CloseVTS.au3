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

    if(WinExists("Outgoing Message")) Then
     WinActivate("Outgoing Message")
	 ControlClick("Outgoing Message", "", "[CLASS:Button; INSTANCE:1]")
  EndIf

   if(WinExists("LogViewer (1)")) Then
     WinActivate("LogViewer (1)")
	 WinMenuSelectItem("LogViewer (1)", "", "&File", "E&xit")
   EndIf

   if(WinExists("Variables Manager")) Then
     WinActivate("Variables Manager")
	 WinMenuSelectItem("Variables Manager", "", "&File", "E&xit")
     ControlClick("Variables Manager", "", "[CLASS:Button; INSTANCE:2]")
  EndIf

   if(WinExists("Visa Test System")) Then
   WinActivate("Visa Test System")
   WinMenuSelectItem("Visa Test System", "", "&Tools", "&Start Communications...")
   WinActivate("VTS Communications Handler")
   Local $sText = ControlGetText ("VTS Communications Handler", "", "[CLASS:Static; INSTANCE:14]")
   if ($sText="UP") Then
	  WinMenuSelectItem("VTS Communications Handler", "", "&Line", "Stop &Line")
   EndIf

   WinMenuSelectItem("VTS Communications Handler", "", "&File", "E&xit")
   WinMenuSelectItem("Visa Test System", "", "&File", "E&xit")
   Sleep(2000)
    if(WinExists("Visa Test System")) Then
	  WinActivate("VTS")
	  ControlClick("VTS", "", "[CLASS:Button; INSTANCE:2]")
   EndIf
EndIf




