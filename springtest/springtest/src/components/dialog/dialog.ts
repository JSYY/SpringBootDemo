import { createVNode, render } from 'vue';
import type { App } from "vue";

//todo ֮�󱳾���ĳ����������Ҫ�Ż����������ÿ�ѡ��
const Message: any = function (DialogComponent: any, options: any) {
    const container = document.createElement('div');
    //��ʱ�޸ı���
    if (DialogComponent.__scopeId != "data-v-6f31a3f4") {
        container.style.background = 'rgba(213, 213, 213, 0.88)';
        container.style.height = '90%';
    } else {
        container.style.height = '100%';
    }
    container.className = "dialog";
    container.style.width = '100%';
    container.style.zIndex = '9999';
    container.style.position = 'fixed';
    container.style.top = '6.5%';
    container.style.borderRadius = '8px';
    //��������ڵ�
    const vm = createVNode(
        DialogComponent,
        options as any,
    );
    //��Ⱦ����ڵ�
    render(vm, container);
    var node = document.querySelector('.app');
    node.appendChild(container);
}

export default {
    //���ע��
    install(app: App): void {
        app.config.globalProperties.$message = Message
    }
}