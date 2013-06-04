package masterfila.jsf.autenticar;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class FaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;
		
	
	public void beforePhase(PhaseEvent fase) {
		
		if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
		}
		
		if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
		}	
	}
	
	public void afterPhase(PhaseEvent fase) {
		if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
		}	
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
