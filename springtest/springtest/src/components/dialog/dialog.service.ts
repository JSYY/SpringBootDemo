import { isNull, isNullOrUndefined } from "util";

class DialogService {
    AddDialogComponent(ins: any, component: any, classname: string, options?: any) {
        let dialog = document.querySelector('.dialog');
        if (isNullOrUndefined(dialog)) {
            if (options) {
                ins!.appContext?.config?.globalProperties.$message(component, options);
            } else {
                ins!.appContext?.config?.globalProperties.$message(component);
            }
        } else if (dialog?.firstElementChild.className != classname) {
            //如果存在dialog了 ，则先移除
            this.RemoveDialogComponent();
            if (options) {
                ins!.appContext?.config?.globalProperties.$message(component, options);
            } else {
                ins!.appContext?.config?.globalProperties.$message(component);
            }
        } else {
            this.RemoveDialogComponent();
        }
    }
    RemoveDialogComponent() {
        let dialog = document.body.querySelector('.dialog');
        //没有找到这个面板返回0
        if (isNullOrUndefined(dialog)) {
            return 0;
        }
        let child = dialog.firstChild;
        dialog.removeChild(child);
        dialog.parentNode.removeChild(dialog);
        return 1;
    }
}
export default new DialogService()