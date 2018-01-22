 #include <MsgBoxConstants.au3>
   #include <WinAPIFiles.au3>
   #include <Constants.au3>

   WinActivate("Visa Test System")
   WinMenuSelectItem("Visa Test System", "", "&Edit", "&Variables Manager...")

   WinWaitActive("Variables Manager","", "100")

   WinSetState("Variables Manager", "", @SW_MAXIMIZE)

   ;WinMenuSelectItem("Variables Manager", "", "&File", "&Open", "&VIP Variables")
    Sleep(9000)