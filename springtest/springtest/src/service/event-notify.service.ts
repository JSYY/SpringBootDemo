import { Subject }  from 'rxjs';
import { filter } from 'rxjs/internal/operators/filter';
import { map } from 'rxjs/internal/operators/map';

class EventNotifyService {
    private serverMsg: Subject<EventMessage> = new Subject<EventMessage>();
    constructor() { }
    public emitEvent(name: string, para: any) {
    const message: EventMessage = {
        type: name,
        payload: para
    };
    this.serverMsg.next(message);
    }

  public onEvent(name: string) {
    return this.serverMsg.pipe(
        filter(msg => msg.type === name),
        map(msg => msg.payload)
    );
  }

  public onAllEvent() {
    return this.serverMsg.pipe();
  }
}

export interface EventMessage {
  type: string;
  payload: any;
}
export default new EventNotifyService()