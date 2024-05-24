package cn.zhiyou.action.child;

import cn.zhiyou.action.CreateSetterGetterMappingAction;
import cn.zhiyou.utils.ActionUtil;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author wcp
 * @since 2024/3/15
 */
public class CreateAllSetterWithDefaultValueAction extends AnAction {
    public CreateAllSetterWithDefaultValueAction() {
        super("List All Setters (带默认值列举Setter)");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        CreateSetterGetterMappingAction.createAllSetter(e, true);
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabled(ActionUtil.isJavaFile(e) && CreateSetterGetterMappingAction.isVarAvailable(e));
    }

}
