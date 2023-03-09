import { useRef } from "react";
import { Link } from "react-router-dom";
import {
  MenuItem,
  SubMenu,
  useHover,
  ControlledMenu,
  useMenuState,
} from "@szhsin/react-menu";
import "@szhsin/react-menu/dist/index.css";
import "@szhsin/react-menu/dist/transitions/slide.css";
import { ICategory } from "../interfaces/category";

interface DropdownProps {
  category: ICategory;
}

export function Dropdown({ category }: DropdownProps) {
  const ref = useRef(null);
  const [menuState, toggle] = useMenuState({ transition: true });
  const { anchorProps, hoverProps } = useHover(menuState.state, toggle);
  const { id, name, subCategories } = category;
  return (
    <>
      <li ref={ref} {...anchorProps} className="p-2">
        {subCategories.length > 0 ? (
          <p className="p-2 hover:bg-slate-50 rounded-md">{name}</p>
        ) : (
          <Link className="p-2 hover:bg-slate-50 rounded-md" to={`/${id}`}>
            {name}
          </Link>
        )}
      </li>

      {subCategories.length > 0 && (
        <ControlledMenu
          {...hoverProps}
          {...menuState}
          anchorRef={ref}
          onClose={() => toggle(false)}
        >
          {subCategories.map((subcategory) => (
            <NestedMenu key={subcategory.id} subcategory={subcategory} />
          ))}
        </ControlledMenu>
      )}
    </>
  );
}

function NestedMenu({ subcategory }: { subcategory: ICategory }) {
  const { id, name, subCategories } = subcategory;

  return subCategories.length ? (
    <SubMenu label={name}>
      {subCategories.map((subcategory) => (
        <NestedMenu key={subcategory.id} subcategory={subcategory} />
      ))}
    </SubMenu>
  ) : (
    <MenuItem>
      <Link to={`/${id}`}>{name}</Link>
    </MenuItem>
  );
}
