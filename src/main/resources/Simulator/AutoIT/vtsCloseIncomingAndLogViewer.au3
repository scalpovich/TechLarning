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

   If(WinExists("Incoming Message")) Then
	  WinActivate("Incoming Message")
	  WinClose("Incoming Message")
	  Sleep(5000)
   EndIf

    If(WinExists("Outgoing Message")) Then
	   WinActivate("Outgoing Message")
	  WinClose("Outgoing Message")
	  Sleep(5000)
   EndIf

    If(WinExists("Variables Manager")) Then
	  WinActivate("Variables Manager")
	  WinMenuSelectItem("Variables Manager", "", "&File", "E&xit")
	  Sleep(5000)
   EndIf

   If(WinExists("LogViewer")) Then
	  WinActivate("LogViewer")
	  WinMenuSelectItem("LogViewer", "", "&File", "E&xit")
	  Sleep(5000)
   EndIf